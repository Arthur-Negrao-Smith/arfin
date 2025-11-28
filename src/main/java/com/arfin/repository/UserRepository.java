package com.arfin.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arfin.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
