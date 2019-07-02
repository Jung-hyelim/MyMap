package com.jhl.mymap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Document {
	
	private String id;
	private String place_name;
	private String category_name;
	private String category_group_code;
	private String category_group_name;
	private String phone;
	private String address_name;
	private String road_address_name;
	private String x;
	private String y;
	private String place_url;
	private String distance;
	
}
