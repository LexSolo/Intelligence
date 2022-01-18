package com.intelligence.user.mapper;

import com.intelligence.user.entity.User;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "password", ignore = true)
  User mapToEntity(UserDto dto);

  UserDto mapToDto(User user);

  List<User> mapToListEntity(List<UserDto> dtos);

  List<UserDto> mapToListDto(List<User> users);

  @AfterMapping
  default void encryptPassword(UserDto dto, @MappingTarget User user) {
    // todo: implement password encrypting
    user.setPassword(dto.getPassword());
  }
}
