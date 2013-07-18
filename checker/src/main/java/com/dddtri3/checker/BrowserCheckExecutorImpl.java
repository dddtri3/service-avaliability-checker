package com.dddtri3.checker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
		
		String title = this.wd.getTitle();
		LOGGER.info(String.format("Resovled to page title[%s]", title));
		if (title == null) {
			title = "";
		}
		url.setTitle(title);
		
		//pattern: 7-18-2013 7:01AM
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mmaaa", Locale.ENGLISH);
		url.setTimeVisted(formatter.format(new Date()));
		
		String status = "ok";
		if (title.toUpperCase().contains("Problem loading page".toUpperCase())) {
			status = "not ok";
		}
		if (title.toUpperCase().contains("The connection was reset".toUpperCase())) {
			status = "not ok";
		}
		if (title.toUpperCase().contains("The connection to the server was reset while the page was loading".toUpperCase())) {
			status = "not ok";
		}
		url.setStatus(status);
		
	}
	public void beforeExecute(Object obj) {
		//do nothing
		
	}
	public void afterExecute(Object obj) {
		
		//close
		if (this.wd != null) {
			try {
				LOGGER.debug("Closing webdriver ...");
				this.wd.quit();	
			} catch (Exception e) {
				LOGGER.error("Cannot quit the webdriver normally.. ", e);
			}
		}
		
	}
	

}
