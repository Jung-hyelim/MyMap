package com.jhl.mymap.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_search")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Search {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100)
	private String keyword;
	
	@Column(length=2)
	private int page;
	
	@Column @CreationTimestamp
	private LocalDateTime search_date;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
}
