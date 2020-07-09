package com.mindtree.newzz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.newzz.entity.Editor;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
	
	public List<Editor> findByIsApprovedFalse();

	public List<Editor> findByIsApprovedTrue();
	
	@Query(value = "UPDATE Editor e SET isApproved=true WHERE e.id=?1")
	@Modifying
	@Transactional
	public void approveEditor(Long editorId);

}
