package com.dddtri3.checker.bean.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

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
			LOGGER.error(e);
			System.exit(1);
		} catch (IOException e) {
			LOGGER.error(e);
			System.exit(1);
		}
	}
	
	public boolean print(File outputFile) {
		
		CSVWriter writer = null;
		
		List<String[]> results = new LinkedList<String[]>();
		results.add(new String[] {"time visited", "url", "title", "status"});
		for (Url url : this.urls) {
			results.add(url.toArray());
		}
		
		try {
			writer = new CSVWriter(new FileWriter(outputFile));
			writer.writeAll(results);
			writer.close();
		} catch (IOException e) {
			LOGGER.error(e);
			return false;
		}
		
		LOGGER.info(String.format("Saving urls result at [%s]..", outputFile.getPath()));
		return true;
	}
	public List<Url> getUrls() {
		return urls;
	}
	
	
}
