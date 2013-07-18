package com.dddtri3.checker.bean.impl;

import com.dddtri3.checker.bean.Url;

public class UrlImpl implements Url {
	private String url;
	
	private String title;
	
	private String timeVisted;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeVisted() {
		return timeVisted;
	}

	public void setTimeVisted(String timeVisted) {
		this.timeVisted = timeVisted;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String val) {
		this.url = val;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String[] toArray() {
		return new String[] {this.timeVisted, this.url, this.title, this.status};
	}
	
}
