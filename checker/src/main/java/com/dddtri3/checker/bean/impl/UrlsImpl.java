package com.dddtri3.checker.bean.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;

import com.dddtri3.checker.bean.Url;
import com.dddtri3.checker.bean.Urls;

public class UrlsImpl implements Urls {

	Logger LOGGER = Logger.getLogger(UrlsImpl.class);
	
	public List<Url> urls = new LinkedList<Url>();
	public UrlsImpl(File file) {
		if (file == null) {
			throw new NullPointerException("file cannot be null!");
		}
		
		
		parse(file);
		
	}
	private void parse(File file) {
		LOGGER.info(String.format("Collecting urls from file[%s]..", file.getPath()));
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			for (String[] rawUrl : reader.readAll()) {
				Url url = new UrlImpl();
				url.setUrl(rawUrl[0]);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(String.format("Added url into list[%s]", url.getUrl()));
				}
				urls.add(url);
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	public List<Url> getUrls() {
		return urls;
	}
	
	
}
