package com.rohit.questionaire.util;

import java.net.MalformedURLException;
import java.net.URL;

public class TinyUrlUtil {

	public static boolean isUrlValid(String url) {
		boolean valid = true;
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			valid = false;
		}
		return valid;
	}
}
