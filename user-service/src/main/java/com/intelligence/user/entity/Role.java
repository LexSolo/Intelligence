package com.intelligence.user.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id")
  private UUID id;

  @Column(name = "name")
  private String name;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  @Getter
  @RequiredArgsConstructor
  public enum RoleEnum {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_MODERATOR("ROLE_MODERATOR"),
    ROLE_USER("ROLE_USER"),
    ROLE_ANONYMOUS("ROLE_ANONYMOUS");

    private final String value;

    @JsonCreator
    public static RoleEnum fromValue(String value) {
      return Stream.of(RoleEnum.values())
          .filter(role -> role.value.equalsIgnoreCase(value))
          .findFirst()
          .orElseThrow(() -> new IllegalArgumentException("Unexpected value '" + value + "'"));
    }
  }
}
