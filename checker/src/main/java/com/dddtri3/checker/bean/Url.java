package com.dddtri3.checker.bean;

public interface Url {
	
	String getTimeVisted();
	
	void setTimeVisted(String val);

	String getUrl();

	void setUrl(String val);
	
	
	String getTitle();
	
	void setTitle(String val);
	
	String[] toArray();
	
	String getStatus();
	
	void setStatus(String status);
}
