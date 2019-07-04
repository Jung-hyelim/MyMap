package com.jhl.mymap.users;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jhl.mymap.TestData;
import com.jhl.mymap.entity.Users;
import com.jhl.mymap.service.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UsersServiceTest {

	@Autowired
	private UsersService usersService;

	@Test
	public void 사용자생성_조회() {
		// 사용자 생성
		Users user = usersService.createUser(TestData.username, TestData.password);
		
		assertThat(user).isNotNull();
		assertThat(user.getId()).isNotNull();
		assertThat(user.getUsername()).isEqualTo(TestData.username);
		assertThat(user.getPassword()).isNotEqualTo(TestData.password);
		
		// 사용자 조회
		Users loadUser = (Users) usersService.loadUserByUsername(TestData.username);

		assertThat(loadUser).isNotNull();
		assertThat(loadUser.getId()).isNotNull();
		assertThat(loadUser.getUsername()).isEqualTo(TestData.username);
	}
	
	@Test(expected=UsernameNotFoundException.class)
	public void 비사용자조회시_예외발생() {
		usersService.loadUserByUsername("-");
	}
	
}
