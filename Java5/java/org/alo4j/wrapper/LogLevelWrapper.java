package org.alo4j.wrapper;

public interface LogLevelWrapper {
	public void error(String message);
	
	public void warn(String message);
	
	public void info(String message);
	
	public void debug(String message);
	
	public void trace(String message);
	
	public void error(Log log);
	
	public void warn(Log log);
	
	public void info(Log log);
	
	public void debug(Log log);
	
	public void trace(Log log);
}
