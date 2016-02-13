package org.alo4j.helper.formatter;

public class CallerLineFormatter {
	public StringBuilder format(StackTraceElement element){
		StringBuilder sb = new StringBuilder();
		
		sb.append("at ").append(element.getClassName()).append(".").append(element.getMethodName())
			.append("(").append(element.getFileName()).append(":").append(element.getLineNumber()).append(")");
		
		return sb;
	}
	

}
