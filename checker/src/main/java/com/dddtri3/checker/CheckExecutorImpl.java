package com.dddtri3.checker;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dddtri3.checker.bean.Url;
import com.dddtri3.checker.bean.Urls;

public class CheckExecutorImpl implements CheckExecutor {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
		        new String[] {"context-executor.xml"});
		CheckExecutor exe = (CheckExecutor) appContext.getBean("exe");
		exe.execute(appContext.getBean("urls"));
	}

	private CheckExecutor executor;
	public CheckExecutorImpl(CheckExecutor executor) {
		if (executor == null) {
			throw new NullPointerException("executor cannot be null!");
		}
		this.executor = executor;
	}
	
	public void execute(Object obj) {
		this.executor.beforeExecute(obj);
		
		
		Urls urls = (Urls) obj;
		for (Url url : urls.getUrls()) {
			this.executor.execute(url);
		}
		
		this.executor.afterExecute(obj);
		
	}

	public void beforeExecute(Object obj) {
		this.executor.beforeExecute(obj);
	}

	public void afterExecute(Object obj) {
		this.executor.afterExecute(obj);
	}

}
