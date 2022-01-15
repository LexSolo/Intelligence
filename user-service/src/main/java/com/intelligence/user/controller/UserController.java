package com.intelligence.user.controller;

import com.intelligence.user.mapper.UserMapper;
import com.intelligence.user.openapi.api.UserApi;
import com.intelligence.user.service.UserService;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

  private final UserService userService;
  private final UserMapper userMapper;

  @Override
  public ResponseEntity<List<UserDto>> findAllUsers() {
    return ResponseEntity.ok(userMapper.mapToListDto(userService.findAllUsers()));
  }

  @Override
  public ResponseEntity<UserDto> addUser(@Valid UserDto userDto) {
    return ResponseEntity.ok(userMapper.mapToDto(userService.createUser(userDto)));
  }

  @Override
  public ResponseEntity<UserDto> findUserById(UUID id) {
    return ResponseEntity.ok(userMapper.mapToDto(userService.findUserById(id)));
  }

  @Override
  public ResponseEntity<Void> deleteUserById(UUID id) {
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }
}
