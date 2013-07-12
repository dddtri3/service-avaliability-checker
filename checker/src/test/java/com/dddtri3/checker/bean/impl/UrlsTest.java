package com.dddtri3.checker.bean.impl;

import junit.framework.Assert;

import org.junit.Test;

import com.dddtri3.checker.TestBase;
import com.dddtri3.checker.bean.Urls;


public class UrlsTest extends TestBase  {

	@Test
	public void testGetUrls() {
		Urls urls = (Urls) this.applicationContext.getBean("urls");
		Assert.assertEquals(3, urls.getUrls().size());
	}
}
