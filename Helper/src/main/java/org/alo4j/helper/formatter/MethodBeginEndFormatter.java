package org.alo4j.helper.formatter;

public class MethodBeginEndFormatter {
	public String formatBegin(StackTraceElement element, Object... params){
		StringBuilder sb = new StringBuilder("Begin method");
		sb.append(" [").append(element.getMethodName()).append("]");
		
		ObjectDetailFormatter objectDetailFormatter = new ObjectDetailFormatter();
		
		int index = 0;
		for(Object param: params){
			sb.append("\n")
				.append(objectDetailFormatter.format("param["+index+"]", param));
			index++;
		}
		
		return sb.toString();
	}
	
	public String formatEnd(StackTraceElement element, Object returnValue){
		StringBuilder sb = new StringBuilder("End method");
		sb.append(" [").append(element.getMethodName()).append("]\n");
		
		if(returnValue != null){
			ObjectDetailFormatter objectDetailFormatter = new ObjectDetailFormatter();
			sb.append(objectDetailFormatter.format("return", returnValue));
		}
		
		return sb.toString();
	}
}
