package com.firstadvertisement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.firstadvertisement.entity.User;
@Component
public interface UserRepository extends JpaRepository<User,Long>{

	List <User> findByusername(String username);

	List<User> findBySessionId(String id);

	List<User> findByOrderByusernameAsc();

	List<User> findByOrderByusernameDesc();
}
