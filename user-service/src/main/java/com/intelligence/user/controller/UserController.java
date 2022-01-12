package com.intelligence.user.controller;

import com.intelligence.user.openapi.api.UserApi;
import com.intelligence.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<List<UserDto>> searchUsers() {
    return null;
  }
}
