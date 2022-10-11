package com.example.qabul.repository;

import com.example.qabul.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByIdAndDeletedAtIsNull(Integer id);
}
