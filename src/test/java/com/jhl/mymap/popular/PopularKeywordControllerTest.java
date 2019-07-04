package com.jhl.mymap.popular;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jhl.mymap.TestData;
import com.jhl.mymap.entity.Search;
import com.jhl.mymap.repository.SearchRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@TestPropertySource("classpath:application-test.properties")
public class PopularKeywordControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Autowired
	private SearchRepository searchRepository;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		Map<String, Integer> map = TestData.popularData();
		
		map.keySet().stream().forEach(k -> {
			for(int i = 0; i < map.get(k); i++){
				searchRepository.save(new Search(null, k, 1, null, null));
			}
		});
		
		// 인기검색어 셋팅
		mockMvc.perform(post("/setPopular")).andExpect(status().isOk());
	}
	
	@Test
	public void 인기검색어조회() throws Exception {
		mockMvc.perform(get("/popular"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$").isNotEmpty())
			.andExpect(jsonPath("$").isArray());
	}
}
