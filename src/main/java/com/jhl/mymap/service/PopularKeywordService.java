package com.jhl.mymap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhl.mymap.entity.PopularKeyword;
import com.jhl.mymap.repository.PopularKeywordRepository;

@Service
public class PopularKeywordService {

	@Autowired
	private PopularKeywordRepository popularKeywordRepository;

	@Transactional(readOnly=false)
	public int setTop10() {
		popularKeywordRepository.deleteAll();
		return popularKeywordRepository.insertTop10();
	}

	@Transactional(readOnly=true)
	public List<PopularKeyword> getTop10() {
		return popularKeywordRepository.findAll();
	}
}
