package com.jhl.mymap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhl.mymap.entity.PopularKeyword;
import com.jhl.mymap.service.PopularKeywordService;

@RestController
public class PopularKeywordController {

	@Autowired
	private PopularKeywordService popularKeywordService;
	
	@GetMapping("/popular")
	public List<PopularKeyword> getPopularKeywords() {
		List<PopularKeyword> list = popularKeywordService.getTop10();
		return list;
	}
	
	@Scheduled(cron="0 * * * * *")
	@GetMapping("/setPopular")
	public void setPopularKeywords() {
		popularKeywordService.setTop10();
	}
}
