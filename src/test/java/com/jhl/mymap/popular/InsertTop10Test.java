package com.jhl.mymap.popular;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jhl.mymap.TestData;
import com.jhl.mymap.entity.Search;
import com.jhl.mymap.repository.SearchRepository;
import com.jhl.mymap.service.PopularKeywordService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class InsertTop10Test {

	@Autowired
	private PopularKeywordService popularKeywordService;

	@Autowired
	private SearchRepository searchRepository;
	
	@Before
	public void 검색데이터저장() {
		// 인기 검색어 데이터
		Map<String, Integer> map = TestData.popularData();
		
		map.keySet().stream().forEach(k -> {
			for(int i = 0; i < map.get(k); i++){
				searchRepository.save(new Search(null, k, 1, null, null));
			}
		});
	}
	
	@Test
	public void 인기검색어TOP10저장() {
		int cnt = popularKeywordService.setTop10();
		
		assertThat(cnt).isEqualTo(10);
	}
}
