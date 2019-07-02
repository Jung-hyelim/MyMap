package com.jhl.mymap.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jhl.mymap.service.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class LoadNonUserTest {

	@Autowired
	private UsersService usersService;

	@Test(expected=UsernameNotFoundException.class)
	public void 비사용자조회시_예외발생() {
		usersService.loadUserByUsername("");
	}
	
}
