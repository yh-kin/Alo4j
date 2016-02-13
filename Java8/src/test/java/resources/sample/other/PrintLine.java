package resources.sample.other;

import org.alo4j.helper.Alo4jHelper;
import org.alo4j.wrapper.Alo4jWrapper;

import resources.logger.ExceptionLogger;

public class PrintLine {
	private final ExceptionLogger slf4jLogger = new ExceptionLogger();
	
	public void printCurrentLine(){
		Alo4jWrapper.wrap(slf4jLogger).trace(Alo4jHelper.currentLocation("test message"));
	}
}
