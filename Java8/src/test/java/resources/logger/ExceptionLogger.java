package resources.logger;

import org.slf4j.Logger;
import org.slf4j.Marker;

import resources.exception.LogException;

public class ExceptionLogger implements Logger{
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void trace(String msg) {
		throw new LogException(msg);
	}

	public void trace(String format, Object arg) {
		// TODO Auto-generated method stub
	}

	public void trace(String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void trace(String format, Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	public void trace(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public boolean isTraceEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return true;
	}

	public void trace(Marker marker, String msg) {
		// TODO Auto-generated method stub
		
	}

	public void trace(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void trace(Marker marker, String format, Object... argArray) {
		// TODO Auto-generated method stub
		
	}

	public void trace(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void debug(String msg) {
		throw new LogException(msg);
		
	}

	public void debug(String format, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void debug(String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void debug(String format, Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	public void debug(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public boolean isDebugEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return true;
	}

	public void debug(Marker marker, String msg) {
		// TODO Auto-generated method stub
		
	}

	public void debug(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void debug(Marker marker, String format, Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	public void debug(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void info(String msg) {
		throw new LogException(msg);
		
	}

	public void info(String format, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void info(String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void info(String format, Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	public void info(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public boolean isInfoEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return true;
	}

	public void info(Marker marker, String msg) {
		// TODO Auto-generated method stub
		
	}

	public void info(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void info(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void info(Marker marker, String format, Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	public void info(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void warn(String msg) {
		throw new LogException(msg);
		
	}

	public void warn(String format, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void warn(String format, Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	public void warn(String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void warn(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public boolean isWarnEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return true;
	}

	public void warn(Marker marker, String msg) {
		// TODO Auto-generated method stub
		
	}

	public void warn(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void warn(Marker marker, String format, Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	public void warn(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void error(String msg) {
		throw new LogException(msg);
		
	}

	public void error(String format, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void error(String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void error(String format, Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	public void error(String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public boolean isErrorEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return true;
	}

	public void error(Marker marker, String msg) {
		// TODO Auto-generated method stub
		
	}

	public void error(Marker marker, String format, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void error(Marker marker, String format, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	public void error(Marker marker, String format, Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	public void error(Marker marker, String msg, Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
