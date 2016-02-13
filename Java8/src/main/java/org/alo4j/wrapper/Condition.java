package org.alo4j.wrapper;

@FunctionalInterface
public interface Condition {
	default public boolean canRun(){
		try{
			return run();
			
		}catch(Throwable t){
			t.printStackTrace();
			return false;
		}
	}
	
	public boolean run();
}
