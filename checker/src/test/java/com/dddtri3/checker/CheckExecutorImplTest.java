package com.dddtri3.checker;

import org.junit.Test;


public class CheckExecutorImplTest extends TestBase {

	@Test
	public void testExecute() {
		CheckExecutor exe = (CheckExecutor) this.applicationContext.getBean("exe");
		exe.execute(this.applicationContext.getBean("urls"));
	}
}
