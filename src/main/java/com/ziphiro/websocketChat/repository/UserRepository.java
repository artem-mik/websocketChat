package com.ziphiro.websocketChat.repository;

import com.ziphiro.websocketChat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findAllByName(String username);
    Optional<User> findByEmail(String email);

}
