package com.intelligence.user.service;

import static com.intelligence.user.util.TextConstants.USER_NOT_FOUND_BY_ID;
import static java.util.stream.Collectors.toSet;

import com.intelligence.user.entity.Role;
import com.intelligence.user.entity.Role.RoleEnum;
import com.intelligence.user.entity.User;
import com.intelligence.user.mapper.UserMapper;
import com.intelligence.user.repository.RoleRepository;
import com.intelligence.user.repository.UserRepository;
import com.intelligence.user.util.TextConstants;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final UserMapper userMapper;
  private final TextConstants textConstants;

  public User findUserById(UUID userId) {
    return userRepository
        .findById(userId)
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    textConstants.getTextMessage(USER_NOT_FOUND_BY_ID, userId)));
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  @Transactional
  public User createUser(UserDto userDto) {
    User user = userMapper.mapToEntity(userDto);
    user.setRoles(grantAuthority(Collections.singleton(RoleEnum.ROLE_USER)));
    return userRepository.save(user);
  }

  private Set<Role> grantAuthority(Set<RoleEnum> roles) {
    return roles.stream().map(role -> roleRepository.findByName(role.name())).collect(toSet());
  }

  @Transactional
  public void deleteUser(UUID userId) {
    User user = findUserById(userId);
    userRepository.deleteById(user.getId());
  }
}
