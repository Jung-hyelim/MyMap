package com.jhl.mymap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class WebClientTest {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	public void test() {
		webTestClient.get().uri("https://dapi.kakao.com/v2/local/search/keyword.json?query=ss")
			.header(HttpHeaders.AUTHORIZATION, "KakaoAK 7a29a83bdb816fd35e6d790458025cc9")
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.exchange()
			.expectStatus().isOk()
			.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
			.expectBody()
			.jsonPath("$.documents").isNotEmpty();
	}
}
