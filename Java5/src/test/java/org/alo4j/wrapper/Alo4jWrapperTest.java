package org.alo4j.wrapper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slf4j.Logger;

import resources.exception.LogException;
import resources.logger.ExceptionLogger;
import resources.sample.PrintLine;

public class Alo4jWrapperTest {

	private Logger slf4j = new ExceptionLogger();
	Alo4jWrapper loggerWrapper = Alo4jWrapper.wrap(slf4j);
	
	@Test
	public void printLocation_basic_test() throws Exception {
		String result = null;
		
		try{
			PrintLine tester = new PrintLine();
			tester.printCurrentLine();
			// without static import
			// logWrapper.trace(Alo4jHelper.currentLocation("test message"));

			// with static
			// logWrapper.trace(currentLocation("test message"));
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		assertThat(result, is("test message >> at resources.sample.PrintLine.printCurrentLine(PrintLine.java:13)"));
	}
	
	@Test
	public void same_class_in_different_package() throws Exception {
		String result = "";
		
		try{
			PrintLine tester = new PrintLine();
			tester.printCurrentLine();
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		assertThat(result, is("test message >> at resources.sample.PrintLine.printCurrentLine(PrintLine.java:13)"));
		
		String other = null;
		
		try{
			resources.sample.other.PrintLine tester = new resources.sample.other.PrintLine();
			tester.printCurrentLine();
			
		}catch(LogException re){
			other = re.getMessage();
		}
		
		assertThat(other, is("test message >> at resources.sample.other.PrintLine.printCurrentLine(PrintLine.java:12)"));
	}
	
	@Test
	public void begin_method() throws Exception {
		String result = null;
		
		try{
			PrintLine tester = new PrintLine();
			tester.printMethodBegin("this is string", 123);
			// without static import
			// logWrapper.trace(Alo4jHelper.methodBegin(string, integer));

			// with static
			// logWrapper.trace(methodBegin(string, integer));
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		String expected = 
				"Begin method [printMethodBegin]\n" + 
				"param[0]<java.lang.String>: this is string\n" + 
				"param[1]<java.lang.Integer>: 123";
		
		assertThat(result, is(expected));
	}
	
	@Test
	public void end_method() throws Exception {
		String result = null;
		
		try{
			PrintLine tester = new PrintLine();
			tester.printMethodEnd();
			// without static import
			// logWrapper.trace(Alo4jHelper.methodEnd(result));

			// with static
			// logWrapper.trace(methodEnd(result));
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		String expected = 
				"End method [printMethodEnd]\n" + 
				"return<java.lang.Boolean>: false";
		
		assertThat(result, is(expected));
	}
	
	@Test
	public void chaining_test1() throws Exception {

		String result = "";
		try{
			loggerWrapper.when(false).trace("this is trace condition");
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		assertThat(result, is(""));
	}
	
	@Test
	public void chaining_test2() throws Exception {
		String result = "";
		try{
			loggerWrapper.when(true).error("this is error condition");

//		if(logger.isDebug()){
//			if(condition){
//				logger.error("this is error condition");
//			}
//		}
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		assertThat(result, is("this is error condition"));
	}
	
	@Test
	public void lambda_function1() throws Exception {
		String result = "";
		try{
			loggerWrapper.when(true).debug(new Log() {
				public String print() {
					return "this is debug in F.run";
				}
			});
			
//		if(logger.isDebug()){
//			if(condition){
//				logger.error("this is debug in F.run");
//			}
//		}
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		assertThat(result, is("this is debug in F.run"));
	}
	
	@Test
	public void lambda_function_with_when() throws Exception {
		String result = "";
		try{
			loggerWrapper.when(true).trace(new Log() {
				public String print() {
					return "this is trace in F.run";
				}
			});
			
//			if(logger.isTrace()){
//				if(condition){
//					logger.trace("this is trace in F.run");
//				}
//			}
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		assertThat(result, is("this is trace in F.run"));
	}
	
	@Test
	public void lambda_condition() throws Exception {
		String result = "";
		try{
			loggerWrapper.when(new Condition() {
				protected boolean run() {
					return true;
				}
			}).trace(new Log() {
				public String print() {
					return "this should be printed";
				}
			});
			
//			if(logger.isTrace()){
//				if(condition){
//					logger.trace("this is trace in F.run");
//				}
//			}
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		assertThat(result, is("this should be printed"));
	}
	
	@Test
	public void lambda_condition2() throws Exception {
		String result = "";
		try{
			loggerWrapper.when(new Condition() {
				protected boolean run() {
					return false;
				}
			}).trace(new Log() {
				public String print() {
					return "this should be printed";
				}
			});
			
//			if(logger.isTrace()){
//				if(condition){
//					logger.trace("this is trace in F.run");
//				}
//			}
			
		}catch(LogException re){
			result = re.getMessage();
		}
		
		assertThat(result, is(""));
	}

}
