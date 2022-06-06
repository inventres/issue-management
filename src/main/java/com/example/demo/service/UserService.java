package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.util.TPage;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto save(UserDto userDto);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);

    Boolean delete(User user);
}
