package com.mindtree.newzz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.newzz.entity.Editor;
import com.mindtree.newzz.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM Comment c where c.post.id = ?1")
	public void deleteCommentsByPostId(Long postId);

	public List<Post> findByEditor(Editor editor);
	
//	@Query(value = "SELECT p FROM Post p where p.tags CONTAINING (:names)")
//	public List<Post> findByTags(@Param("names")List<Tag> tags);

}
