package org.alo4j.wrapper;

public abstract class Log {
	public String getLog(){
		try{
			return print();
			
		}catch(Throwable t){
			t.printStackTrace();
			return "Exception while logging["+t.getMessage()+"]";
		}
	}
	
	abstract protected String print();
}
