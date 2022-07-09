package com.example.demo.implementation;

import java.io.File;
import java.util.Random;

import org.apache.commons.validator.routines.UrlValidator;

public class QRCodeImplementation {
	

	public String shortenURL(String inputURL) {
		Random random= new Random();
		int randInt=random.nextInt(1000);
		return "shortURL.su/"+randInt;
	}
	
	public boolean validateURL(String url) {
		UrlValidator urlValidator = new UrlValidator();
		return urlValidator.isValid("https://"+url);
	}
}
