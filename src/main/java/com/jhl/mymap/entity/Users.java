package com.jhl.mymap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_users")
@Getter
//@Setter
@NoArgsConstructor
public class Users {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false, length=10)
	private String username;

	@Column(nullable=false)
	private String password;
	
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
