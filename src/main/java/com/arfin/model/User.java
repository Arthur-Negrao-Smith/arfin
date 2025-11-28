package com.arfin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private Long id;

  private String name;

  private String hashed_password;

  private String salt;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
