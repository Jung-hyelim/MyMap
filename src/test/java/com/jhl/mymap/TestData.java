package com.jhl.mymap;

import java.util.HashMap;
import java.util.Map;

public class TestData {

	// Users
	public static String username = "username";
	public static String password = "password";
	
	// Search
	public static String keyword = "pasta";
	public static int page = 1;
	
	// 인기검색어를 위한 데이터
	public static Map<String, Integer> popularData() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("남산", 10);
		map.put("부산", 9);
		map.put("제주 맛집", 2);
		map.put("명동 맛집", 8);
		map.put("pasta", 7);
		map.put("파스타", 6);
		map.put("카페", 5);
		map.put("분위기 좋은 카페", 4);
		map.put("안동", 1);
		map.put("강릉 명소", 3);
		map.put("여의도", 15);
		return map;
	}
}
