package org.alo4j.helper.formatter;

public class CallerLineFormatter {
	public String format(String message, StackTraceElement element){
		StringBuilder sb = new StringBuilder(message);
		
		sb.append(" >> at ").append(element.getClassName()).append(".").append(element.getMethodName())
			.append("(").append(element.getFileName()).append(":").append(element.getLineNumber()).append(")");
		
		return sb.toString();
	}
	

}
