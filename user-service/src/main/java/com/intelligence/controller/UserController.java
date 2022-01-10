package com.intelligence.controller;

import com.intelligence.entity.User;
import com.intelligence.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  @GetMapping
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  @PostMapping
  public User createUser(User user) {
    return userRepository.save(user);
  }
}
