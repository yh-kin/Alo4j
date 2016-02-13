package org.alo4j.wrapper;

import org.slf4j.Logger;

public class Alo4jWrapper implements LogLevelWrapper{
	private final Logger logger;
	private Condition condition = () -> {return true;};
	
	private Alo4jWrapper(Logger logger) {
		this.logger = logger;
	}
	
	public static Alo4jWrapper wrap(Logger logger){
		Alo4jWrapper wrapper = new Alo4jWrapper(logger);
		return wrapper;
	}
	
	public void error(Log runnable){
		print(Level.ERROR, runnable);
	}
	
	public void error(final String message){
		this.error(() -> {return message;});
	}
	
	public void warn(Log runnable){
		print(Level.WARN, runnable);
	}
	
	public void warn(final String message){
		this.warn(() -> {return message;});
	}
	
	public void info(Log runnable){
		print(Level.INFO, runnable);
	}
	
	public void info(final String message){
		this.info(() -> {return message;});
	}
	
	public void debug(Log runnable){
		print(Level.DEBUG, runnable);
	}
	
	public void debug(final String message){
		this.debug(() -> {return message;});
	}
	
	public void trace(Log runnable){
		print(Level.TRACE, runnable);
	}
	
	public void trace(final String message){
		this.trace(() -> {return message;});
	}
	
	private void print(Level level, Log log) {
		switch(level){
		case ERROR:
			if(logger.isErrorEnabled() && condition.canRun())
				logger.error(log.getLog());break;
		case WARN: 
			if(logger.isWarnEnabled() && condition.canRun())
				logger.warn(log.getLog()); break;
		case INFO: 
			if(logger.isInfoEnabled() && condition.canRun())
				logger.info(log.getLog()); break;
		case DEBUG: 
			if(logger.isDebugEnabled() && condition.canRun())
				logger.debug(log.getLog()); break;
		default: 
			if(logger.isTraceEnabled() && condition.canRun())
				logger.trace(log.getLog()); break; // + Trace
		}
	}

	public LogLevelWrapper when(Condition condition){
		Alo4jWrapper wrapper = new Alo4jWrapper(logger);
		wrapper.condition = condition;

		return wrapper;
	}
	
	public LogLevelWrapper when(final boolean condition) {
		return when(() -> {return condition;});
	}

	public static enum Level{
		ERROR, WARN, INFO, DEBUG, TRACE;
	}
}