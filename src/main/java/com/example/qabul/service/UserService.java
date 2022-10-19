package com.example.qabul.service;

import com.example.qabul.dto.UserDto;
import com.example.qabul.entity.User;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserDto get(Integer id) {
        return null;
    }

    public UserDto create(UserDto dto) {
        return null;
    }

    public boolean update(Integer id, UserDto dto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }

    public User getEntity(Integer id){
        Optional<User> optional = userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("User not found");
        }
        return optional.get();
    }
}
