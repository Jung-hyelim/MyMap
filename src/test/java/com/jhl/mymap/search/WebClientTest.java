package com.jhl.mymap.search;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.jhl.mymap.TestData;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class WebClientTest {

	@Autowired
	private WebTestClient webTestClient;
	
//	@Autowired
//	private WebTestClient.Builder webTestClientBuilder;
//	
//	private WebTestClient webTestClient;
	
	@Value("${kakao.api.host}")
	private String host;

	@Value("${kakao.api.uri}")
	private String uri;

	@Value("${kakao.api.key}")
	private String authorization_key;
	
	@Before
	public void setup() {
		webTestClient = webTestClient
						.mutate()
						.baseUrl(host)
						.defaultHeader(HttpHeaders.AUTHORIZATION, authorization_key)
						.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
						.build();
	}
	
	@Test
	public void test() {
		webTestClient
			.get()
			.uri(uriBuilder -> uriBuilder
				.path(uri)
				.queryParam("query", TestData.keyword)
				.queryParam("page", TestData.page)
				.build())
			.exchange()
			.expectStatus().isOk()
			.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
			.expectBody()
			.jsonPath("$.meta").isNotEmpty()
			.jsonPath("$.documents").isNotEmpty();
	}
}
