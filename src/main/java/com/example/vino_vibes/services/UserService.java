package com.example.vino_vibes.services;

import com.example.vino_vibes.dtos.user.UserMapper;
import com.example.vino_vibes.dtos.user.UserRequest;
import com.example.vino_vibes.dtos.user.UserRequestByAdmin;
import com.example.vino_vibes.dtos.user.UserResponse;
import com.example.vino_vibes.exceptions.EntityAlreadyExistsException;
import com.example.vino_vibes.exceptions.EntityNotFoundException;
import com.example.vino_vibes.models.User;
import com.example.vino_vibes.repositories.UserRepository;
import com.example.vino_vibes.security.CustomUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> UserMapper.toDto(user)).toList();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(User.class.getSimpleName(), "Id", id.toString()));
    }

    public UserResponse getUserResponseById(Long id) {
        return UserMapper.toDto(getUserById(id));
    }

    public UserResponse addUser(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.username())) {
            throw new EntityAlreadyExistsException(User.class.getSimpleName(), "username", userRequest.username());
        }
        User newUser = UserMapper.toEntity(userRequest);
        newUser.setPassword(passwordEncoder.encode(userRequest.password()));
        User savedUser = userRepository.save(newUser);
        return UserMapper.toDto(savedUser);
    }

    public UserResponse updateUser(Long id, UserRequest userRequest) {
        User updatedUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(User.class.getSimpleName(), "id", id.toString()));
        updatedUser.setUsername(userRequest.username());
        updatedUser.setEmail(userRequest.email());
        updatedUser.setPassword(passwordEncoder.encode(userRequest.password()));
        User newUser = userRepository.save(updatedUser);
        return UserMapper.toDto(newUser);
    }

    public UserResponse updateUserByAdmin(Long id, UserRequestByAdmin userRequestByAdmin) {
        User updatedUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class.getSimpleName(), "id", id.toString()));
        UserMapper.toEntityFromAdmin(userRequestByAdmin, updatedUser);
        User savedUser = userRepository.save(updatedUser);
        return UserMapper.toDto(savedUser);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(User.class.getSimpleName(), "id", id.toString());
        }
        getUserById(id);
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws EntityNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> new CustomUserDetail(user))
                .orElseThrow(() -> new EntityNotFoundException(User.class.getSimpleName(), "username", username));
    }
}
