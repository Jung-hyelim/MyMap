package com.jhl.mymap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_popular_keyword")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PopularKeyword {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=2, nullable=false)
	private int rank;
	
	@Column(length=100, nullable=false)
	private String keyword;
	
	@Column(nullable=false)
	private int search_count;
	
}
