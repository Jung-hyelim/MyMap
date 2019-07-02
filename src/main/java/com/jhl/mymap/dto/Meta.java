package com.jhl.mymap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meta {

	private int total_count;
	private int pageable_count;
	private Boolean is_end;
	
}
