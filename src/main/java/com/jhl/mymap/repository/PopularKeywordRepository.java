package com.jhl.mymap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jhl.mymap.entity.PopularKeyword;

public interface PopularKeywordRepository extends JpaRepository<PopularKeyword, Long> {

	@Modifying
	@Query(nativeQuery = true,
			value = "INSERT INTO TB_POPULAR_KEYWORD (RANK, KEYWORD, SEARCH_COUNT) "
					+ "SELECT ROW_NUMBER() OVER () AS RANK, KEYWORD, SEARCH_COUNT  FROM (SELECT KEYWORD, COUNT(KEYWORD) SEARCH_COUNT FROM TB_SEARCH GROUP BY KEYWORD ORDER BY SEARCH_COUNT DESC LIMIT 10)")
	public int insertTop10();
}
