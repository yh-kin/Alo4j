package resources.sample;

import org.alo4j.helper.Alo4jHelper;
import org.alo4j.wrapper.Alo4jWrapper;

import resources.logger.ExceptionLogger;
import resources.variable.IterableVariable;

public class PrintLine {
	private final ExceptionLogger slf4jLogger = new ExceptionLogger();

	public void printCurrentLine() {
		Alo4jWrapper.wrap(slf4jLogger).trace(Alo4jHelper.currentLocation("test message"));
	}

	public void printMethodBegin(String string, int integer) {
		Alo4jWrapper.wrap(slf4jLogger).trace(Alo4jHelper.methodBegin(string, integer));
		
		// Doing something..
		// ...
		// ...
		// ...
		// ...
	}
	
	public void printMethodBeginWithObjectParam(IterableVariable iterable){
		Alo4jWrapper.wrap(slf4jLogger).trace(Alo4jHelper.methodBegin(iterable));
		
		// Doing something..
		// ...
		// ...
		// ...
		// ...
	}

	public boolean printMethodEnd() {
		// Doing something..
		// ...
		// ...
		// ...
		// ...
		
		boolean result = false;

		Alo4jWrapper.wrap(slf4jLogger).trace(Alo4jHelper.methodEnd(result));
		return result;
	}
}
