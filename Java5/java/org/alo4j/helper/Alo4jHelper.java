package org.alo4j.helper;

import org.alo4j.helper.formatter.CallerLineFormatter;
import org.alo4j.helper.formatter.ObjectDetailFormatter;
import org.alo4j.wrapper.Alo4jWrapper;
import org.alo4j.wrapper.Log;

public class Alo4jHelper {
	public static Log methodBegin(final Object... params){
		return new Log() {
			public String print() {
				StringBuilder sb = new StringBuilder("Begin method");
				sb.append(" [").append(getCallerElement().getMethodName()).append("]");
				
				ObjectDetailFormatter objectDetailFormatter = new ObjectDetailFormatter();
				
				int index = 0;
				for(Object param: params){
					sb.append("\n")
						.append(objectDetailFormatter.format("param["+index+"]", param));
					index++;
				}
				
				return sb.toString();
			}
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
	
	public static Log methodEnd(){
		return methodEnd(null);
	}
	
	public static Log methodEnd(final Object returnValue){
		return new Log() {
			public String print() {
				StringBuilder sb = new StringBuilder("End method");
				sb.append(" [").append(getCallerElement().getMethodName()).append("]\n");
				
				if(returnValue != null){
					ObjectDetailFormatter objectDetailFormatter = new ObjectDetailFormatter();
					sb.append(objectDetailFormatter.format("return", returnValue));
				}
				
				return sb.toString();
			}
		};
	}
	
	public static Log variableOf(final String variableName, final Object obj){
		return new Log() {
			public String print() {
				ObjectDetailFormatter formatter = new ObjectDetailFormatter();
				StringBuilder sb = formatter.format(variableName, obj);
				
				return sb.toString();
			}
		};
	}
	
	public static Log currentLocation(final String message){
		return new Log() {
			public String print() {
				CallerLineFormatter formatter = new CallerLineFormatter();
				
				StringBuilder sb = new StringBuilder(message);
				sb.append(" >> ").append(formatter.format(getCallerElement()));
				
				return sb.toString();
			}
		};
	}
}

