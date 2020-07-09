package com.mindtree.newzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.newzz.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
