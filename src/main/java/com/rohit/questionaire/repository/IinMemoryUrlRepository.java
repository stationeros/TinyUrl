package com.rohit.questionaire.repository;

public interface IinMemoryUrlRepository {

	String findUrlById(String id);

	void persistUrl(String id, String url);

}