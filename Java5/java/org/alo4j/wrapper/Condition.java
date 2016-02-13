package org.alo4j.wrapper;

public abstract class Condition {
	public boolean canRun(){
		try{
			return run();
			
		}catch(Throwable t){
			t.printStackTrace();
			return false;
		}
	}
	
	abstract protected boolean run();
}
