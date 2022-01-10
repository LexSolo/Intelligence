package com.intelligence.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)//(generator = "UUID")
//  @GenericGenerator(
//      name = "UUID",
//      strategy = "org.hibernate.id.UUIDGenerator"
//  )
  @Column(name = "id")
  private UUID id;

  @Column(name = "name")
  private String name;
}
