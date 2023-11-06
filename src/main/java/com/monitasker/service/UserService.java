package com.monitasker.service;

import com.monitasker.model.entity.User;
import com.monitasker.model.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) throw new IllegalArgumentException();
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return Optional.of(userRepository.save(updatedUser));
        else return Optional.empty();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
