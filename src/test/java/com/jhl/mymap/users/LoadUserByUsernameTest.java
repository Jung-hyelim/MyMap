package com.jhl.mymap.users;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jhl.mymap.TestData;
import com.jhl.mymap.entity.Users;
import com.jhl.mymap.service.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class LoadUserByUsernameTest {

	@Autowired
	private UsersService usersService;
	
	private Long userId;

	@Before
	public void 사용자생성() {
		Users user = usersService.createUser(TestData.username, TestData.password);
		userId = user.getId();
	}
	
	@After
	public void 사용자삭제() {
		usersService.deleteUser(userId);
	}
	
	@Test
	public void 사용자조회() {
		Users user = (Users) usersService.loadUserByUsername(TestData.username);

		assertThat(user).isNotNull();
		assertThat(user.getId()).isNotNull();
		assertThat(user.getUsername()).isEqualTo(TestData.username);
	}
	
}
