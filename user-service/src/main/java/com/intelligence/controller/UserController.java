package com.intelligence.controller;

import com.intelligence.entity.User;
import com.intelligence.repository.UserRepository;
import com.intelligence.user.api.UserApi;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController implements UserApi {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<Void> searchUsers() {
    return null;
  }
}
