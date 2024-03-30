package com.nisanth.SpringJpaAuth.repository;

import com.nisanth.SpringJpaAuth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>
{
public User findByUsername(String username);
}
