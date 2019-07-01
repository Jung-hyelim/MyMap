package com.jhl.mymap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jhl.mymap.service.UsersService;

@Component
public class UserRunner implements ApplicationRunner {

	@Autowired
	UsersService usersService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 앱 구동시 계정생성
		usersService.createUser("test", "1234");
	}

}
