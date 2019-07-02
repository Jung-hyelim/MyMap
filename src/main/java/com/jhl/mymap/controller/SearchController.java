package com.jhl.mymap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhl.mymap.dto.ApiResult;
import com.jhl.mymap.entity.Users;
import com.jhl.mymap.service.SearchService;

@RestController
public class SearchController {
	
	@Autowired
	private SearchService searchService;

	@GetMapping("/search/{keyword}")
	public ApiResult searchKeyword(@PathVariable(value="keyword") String keyword, 
			@RequestParam(value="page", defaultValue="1") int page, 
			@AuthenticationPrincipal Users customUser) {
		ApiResult apiResult = searchService.searchKeyword(keyword, page, customUser);
		return apiResult;
	}
	
}
