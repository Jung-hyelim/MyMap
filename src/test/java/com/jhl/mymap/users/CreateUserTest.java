package com.jhl.mymap.users;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jhl.mymap.TestData;
import com.jhl.mymap.entity.Users;
import com.jhl.mymap.service.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class CreateUserTest {

	@Autowired
	private UsersService usersService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void 사용자생성() {
		Users user = usersService.createUser(TestData.username, TestData.password);
		
		assertThat(user).isNotNull();
		assertThat(user.getId()).isNotNull();
		assertThat(user.getUsername()).isEqualTo(TestData.username);
		assertThat(user.getPassword()).isNotEqualTo(TestData.password);
		assertThat(user.getPassword()).isEqualTo(passwordEncoder.encode(TestData.password));
	}
}
