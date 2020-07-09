package com.mindtree.newzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.newzz.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
