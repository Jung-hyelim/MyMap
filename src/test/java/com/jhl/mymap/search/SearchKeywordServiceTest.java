package com.jhl.mymap.search;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jhl.mymap.TestData;
import com.jhl.mymap.dto.ApiResult;
import com.jhl.mymap.entity.Search;
import com.jhl.mymap.entity.Users;
import com.jhl.mymap.repository.SearchRepository;
import com.jhl.mymap.service.SearchService;
import com.jhl.mymap.service.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class SearchKeywordServiceTest {

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private SearchRepository searchRepository;
	
	@Autowired
	private UsersService usersService;

	Users user = null;
	
	@Before
	public void 사용자생성() {
		user = new Users(99L, TestData.username, TestData.password);
	}
	
	@Test
	public void 키워드검색후_검색테이블에저장되었는지확인() {
		ApiResult result = searchService.searchKeyword(TestData.keyword, TestData.page, user);

		assertThat(result).isNotNull();
		assertThat(result.getMeta()).isNotNull();
		assertThat(result.getDocuments()).isNotNull();
		assertThat(result.getDocuments().size()).isBetween(0, 15);
		
		// 검색 테이블에 저장되었는지 확인
		List<Search> search = searchRepository.findAll();
		
		assertThat(search).isNotNull();
		assertThat(search).isNotEmpty();
		assertThat(search).filteredOn(c -> c.getKeyword().contains(TestData.keyword));
	}
}
