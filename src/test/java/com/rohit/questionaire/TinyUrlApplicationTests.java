package com.rohit.questionaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.rohit.questionaire.model.RedirectUrl;
import com.rohit.questionaire.model.TinyUrl;
import com.rohit.questionaire.rest.TinyUrlRequestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TinyUrlApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired TinyUrlRequestController controller;
	@Test
	public void testController() {
		String url = "https://www.amazon.com/gp/help/customer/display.html/?nodeId=10683361";
		String expected = "https://www.amazon.com/bebc80";
		ResponseEntity<TinyUrl> entity = controller.createTinyUrl(url);
		assertEquals(expected, entity.getBody().getTinyUrl());
		
		//Merging these two as I am using an inMemoryDB.
		String id = "bebc80";
		String expectedUrl = "https://www.amazon.com/gp/help/customer/display.html/?nodeId=10683361";
		ResponseEntity<RedirectUrl> ety = controller.redirectToUrl(id);
		assertEquals(expectedUrl, ety.getBody().getUrl());
	}
	

	
	@Test
	public void testControllerInvalidUrl() {
		String url = "123";
		String expected = null;
		ResponseEntity<TinyUrl> entity = controller.createTinyUrl(url);
		assertEquals(expected, entity.getBody());
	}
	

}
