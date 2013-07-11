package com.dddtri3.checker;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class UrlsTest extends AbstractJUnit4SpringContextTests  {

	@Test
	public void testGetUrls() {
		Urls urls = (Urls) this.applicationContext.getBean("urls");
		Assert.assertEquals(3, urls.getUrls().size());
		
	}
}
