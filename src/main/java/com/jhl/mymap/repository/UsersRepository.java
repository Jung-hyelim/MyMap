package com.jhl.mymap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhl.mymap.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByUsername(String username);
}
