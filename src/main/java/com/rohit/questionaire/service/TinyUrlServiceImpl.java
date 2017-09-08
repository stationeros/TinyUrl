package com.rohit.questionaire.service;

import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.rohit.questionaire.model.RedirectUrl;
import com.rohit.questionaire.model.TinyUrl;
import com.rohit.questionaire.repository.IinMemoryUrlRepository;
import com.rohit.questionaire.util.TinyUrlUtil;

@Service
public class TinyUrlServiceImpl implements TinyUrlService {

	private final IinMemoryUrlRepository inMemoryUrlStoreRepository;

	public TinyUrlServiceImpl(IinMemoryUrlRepository inMemoryUrlStoreRepository) {
		this.inMemoryUrlStoreRepository = inMemoryUrlStoreRepository;
	}

	@Override
	public TinyUrl shortenUrl(String url) {
		String resultUrl = null;
		String id = null;
		TinyUrl tinyUrl = null;
		if (TinyUrlUtil.isUrlValid(url)) {
			try {
				// Using google Guava Hashing method here.
				id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
				id = id.substring(0, 6);
				inMemoryUrlStoreRepository.persistUrl(id, url);
				URL requestUrl = new URL(url);
				String protocol = requestUrl.getProtocol();
				String host = requestUrl.getHost();
				resultUrl = protocol + "://" + host + "/" + id;
				tinyUrl = new TinyUrl(id, resultUrl);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tinyUrl;
	}

	@Override
	public RedirectUrl redirectToUrl(String id) {
		RedirectUrl redirectUrl = null;
		String url = inMemoryUrlStoreRepository.findUrlById(id);
		if (url != null) {
			String reString =  inMemoryUrlStoreRepository.findUrlById(id);
			redirectUrl = new RedirectUrl(reString);
		} 
		return redirectUrl;

	}

}
