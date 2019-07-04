package com.jhl.mymap.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jhl.mymap.dto.ApiResult;
import com.jhl.mymap.entity.Search;
import com.jhl.mymap.entity.Users;
import com.jhl.mymap.repository.SearchRepository;

@Service
public class SearchService {

	@Value("${kakao.api.host}")
	private String host;

	@Value("${kakao.api.uri}")
	private String uri;

	@Value("${kakao.api.key}")
	private String authorization_key;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private SearchRepository searchRepository;
	
	@Transactional
	public ApiResult searchKeyword(String keyword, int page, Users user) {
		WebClient webClient = webClientBuilder
								.baseUrl(host)
								.defaultHeader(HttpHeaders.AUTHORIZATION, authorization_key)
								.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
								.build();
		
		ApiResult result = webClient
								.get()
								.uri(uriBuilder -> uriBuilder
									.path(uri)
									.queryParam("query", keyword)
									.queryParam("page", page)
									.build())
								.retrieve()
								.bodyToMono(ApiResult.class)
								.block();

		searchRepository.save(new Search(null, keyword, page, null, user));
		
		return result;
	}
}
