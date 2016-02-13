package org.alo4j.wrapper;

@FunctionalInterface
public interface Log{
	default public String getLog(){
		try{
			return print();
			
		}catch(Throwable t){
			t.printStackTrace();
			return "Exception while logging["+t.getMessage()+"]";
		}
	}
	
	public String print();
}
