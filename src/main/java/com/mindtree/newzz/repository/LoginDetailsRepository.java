package com.mindtree.newzz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.newzz.entity.User;
import com.mindtree.newzz.entity.UserLoginDetails;

@Repository
public interface LoginDetailsRepository extends JpaRepository<UserLoginDetails, Long> {

	
	public Optional<UserLoginDetails> findByEmail(String email);
	
	@Query(value = "SELECT details.user FROM UserLoginDetails details where details.email =?1 and details.password =?2")
	public Optional<User> findByDetails(String email, String password);
	
}
