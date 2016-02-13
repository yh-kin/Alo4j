package org.alo4j.helper;

import org.alo4j.helper.formatter.CallerLineFormatter;
import org.alo4j.helper.formatter.MethodBeginEndFormatter;
import org.alo4j.helper.formatter.ObjectDetailFormatter;
import org.alo4j.wrapper.Alo4jWrapper;
import org.alo4j.wrapper.Log;

public class Alo4jHelper {
	public static Log methodBegin(final Object... params){
		MethodBeginEndFormatter formatter = new MethodBeginEndFormatter();
		
		return () -> {
			return formatter.formatBegin(getCallerElement(), params);
		};
	}
	
	public static Log methodEnd(){
		return methodEnd(null);
	}
	
	public static Log methodEnd(final Object returnValue){
		MethodBeginEndFormatter formatter = new MethodBeginEndFormatter();
		
		return () -> {
			return formatter.formatEnd(getCallerElement(), returnValue);
		};
	}
	
	public static Log variableOf(final String variableName, final Object obj){
		ObjectDetailFormatter formatter = new ObjectDetailFormatter();
		
		return () -> {
			return formatter.format(variableName, obj);
		};
	}
	
	public static Log currentLocation(final String message){
		CallerLineFormatter formatter = new CallerLineFormatter();
		
		return () -> {
			return formatter.format(message, getCallerElement());
		};
	}
	
	private static StackTraceElement getCallerElement(){
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for(int i = stackTraceElements.length-1; i>= 0; i--){
			if(isCallerBefore(stackTraceElements[i])){
				return stackTraceElements[i+1];
			}
		}
		
		return null;
	}
	
	private static boolean isCallerBefore(StackTraceElement element){
		return element.getClassName().equals(Alo4jWrapper.class.getName());
	}
}

