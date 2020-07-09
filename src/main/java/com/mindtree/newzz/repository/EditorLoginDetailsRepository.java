package com.mindtree.newzz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.newzz.entity.Editor;
import com.mindtree.newzz.entity.EditorLoginDetails;

@Repository
public interface EditorLoginDetailsRepository extends JpaRepository<EditorLoginDetails, Long> {

	public Optional<EditorLoginDetails> findByEmail(String email);
	
	@Query(value = "SELECT details.editor FROM EditorLoginDetails details where details.email =?1 and details.password =?2")
	public Optional<Editor> findByDetails(String email, String password);
	
}
