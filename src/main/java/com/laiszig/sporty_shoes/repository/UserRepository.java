package com.laiszig.sporty_shoes.repository;

import com.laiszig.sporty_shoes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
