package com.dddtri3.checker;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.dddtri3.checker.bean.Url;


public class BrowserCheckExecutorImpl implements CheckExecutor {

	private static Logger LOGGER= Logger.getLogger(BrowserCheckExecutorImpl.class); 
	private WebDriver wd = null;
	
	public BrowserCheckExecutorImpl(WebDriver wd) {
		if (wd == null) {
			throw new NullPointerException("wd cannot be null!");
		}
		this.wd = wd;
	}
	public void execute(Object obj) {
		Url url = (Url) obj;
		LOGGER.info(String.format("Browsing [%s] url", url.getUrl()));
		this.wd.get(url.getUrl());
		LOGGER.info(String.format("Resovled to page title[%s]", this.wd.getTitle()));
	}
	public void beforeExecute(Object obj) {
		//do nothing
		
	}
	public void afterExecute(Object obj) {
		if (this.wd != null) {
			try {
				this.wd.quit();	
			} catch (Exception e) {
				LOGGER.error("Cannot quit the webdriver normally.. ", e);
			}
		}
	}
	

}
