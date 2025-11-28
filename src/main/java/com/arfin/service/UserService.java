package com.arfin.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.arfin.model.User;
import com.arfin.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public void delete(UUID id) {
    userRepository.deleteById(id);
  }
}
