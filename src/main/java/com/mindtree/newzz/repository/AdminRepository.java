package com.mindtree.newzz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.newzz.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	public Optional<Admin> findByEmail(String email);
	
}
