package com.dddtri3.checker.bean;

import java.io.File;
import java.util.List;

public interface Urls {

	List<Url> getUrls();
	
	boolean print(File file);
}
