package com.greatlearning.debateEvent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.debateEvent.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	@Query("from User u where u.username=?1")
	public User getUserByUserName(String username);
}
