package com.rohit.questionaire.service;

import com.rohit.questionaire.RedirectUrl;
import com.rohit.questionaire.model.TinyUrl;

public interface TinyUrlService {

	TinyUrl shortenUrl(String url);
	RedirectUrl redirectToUrl(String id);
	
}
