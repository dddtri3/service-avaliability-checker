package com.dddtri3.checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class UrlsImpl implements Urls {

	public List<Url> urls = new LinkedList<Url>();
	public UrlsImpl(File file) {
		if (file == null) {
			throw new NullPointerException("file cannot be null!");
		}
		
		
		parse(file);
		
	}
	private void parse(File file) {
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			for (String[] rawUrl : reader.readAll()) {
				Url url = new UrlImpl();
				url.setUrl(rawUrl[0]);
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