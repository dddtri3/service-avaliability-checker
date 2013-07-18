package com.dddtri3.checker;

import org.junit.Test;


public class CheckExecutorImplTest extends TestBase {
	@Test
	public void testExecute() {
		CheckExecutor exe = (CheckExecutor) this.applicationContext.getBean("exe");
		Object urls = this.applicationContext.getBean("urls");
		exe.beforeExecute(urls);
		exe.execute(urls);
		exe.afterExecute(urls);
	}
}
