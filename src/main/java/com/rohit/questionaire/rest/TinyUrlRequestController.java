package com.rohit.questionaire.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.questionaire.model.RedirectUrl;
import com.rohit.questionaire.model.TinyUrl;
import com.rohit.questionaire.service.TinyUrlService;

@RestController
public class TinyUrlRequestController {

	private final TinyUrlService tinyUrlService;
	
	@Autowired
	public TinyUrlRequestController(TinyUrlService tinyUrlService) {
		this.tinyUrlService = tinyUrlService;
	}
	
	@RequestMapping(value="/tiny/create", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<TinyUrl> createTinyUrl(@RequestParam(value="url", required=true) String url) {
		return ResponseEntity.status(HttpStatus.OK).body(tinyUrlService.shortenUrl(url));
	}
	
	@RequestMapping(value="/tiny/redirect", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<RedirectUrl> redirectToUrl(@RequestParam(value="id", required=true) String id) {
		return ResponseEntity.status(HttpStatus.OK).body(tinyUrlService.redirectToUrl(id));
	}
}
