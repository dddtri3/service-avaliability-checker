package com.dddtri3.checker;

public interface CheckExecutor {

	public void beforeExecute(Object obj);
	
	public void execute(Object obj);
	
	public void afterExecute(Object obj);
	
}
