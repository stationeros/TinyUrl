package com.rohit.questionaire.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUrlStoreRepository implements IinMemoryUrlRepository {

	private Map<String, String> urlRepository = new ConcurrentHashMap<>();
	
	/* (non-Javadoc)
	 * @see com.rohit.repository.IinMemoryUrlRepository#findUrlById(java.lang.String)
	 */
	@Override
	public String findUrlById(String id) {
		return urlRepository.get(id);
	}
	
	/* (non-Javadoc)
	 * @see com.rohit.repository.IinMemoryUrlRepository#persistUrl(java.lang.String, java.lang.String)
	 */
	@Override
	public void persistUrl(String id, String url) {
		urlRepository.put(id, url);
	}
}
