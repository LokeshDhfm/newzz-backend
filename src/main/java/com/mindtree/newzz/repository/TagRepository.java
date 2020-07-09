package com.mindtree.newzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.newzz.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

	@Query(value = "SELECT case when count(t) > 0 then true else false end from Tag t where lower(t.name) = lower(?1)")
	public boolean isExists(String tag);

	public Tag findByName(String tagName);

//	@Query(value = "SELECT u.followedTags FROM User u where u.id = ?1")
//	public List<Tag> findByUserFollowedTags(Long userId);
}
