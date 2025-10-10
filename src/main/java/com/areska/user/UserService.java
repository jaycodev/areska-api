package com.areska.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.areska.user.dto.request.ChangePasswordRequest;
import com.areska.user.dto.request.UserCreateRequest;
import com.areska.user.dto.request.UserUpdateRequest;
import com.areska.user.dto.response.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
    
	public List<UserResponse> getList() {
		List<UserResponse> users = new ArrayList<UserResponse>();
		userRepository.findAllWithoutPassword().forEach(users::add);
		return users;
	}

	public Optional<UserResponse> getById(Integer id) {
		return userRepository.findByIdWithoutPassword(id);
	}

	@Transactional(readOnly = false)
	public void deleteById(Integer id) {
		try {
			getById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

			userRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Cannot delete user, there are active relationships.");
		}
	}

	@Transactional(readOnly = false)
	public void editById(Integer id, UserUpdateRequest userUpdate) {
		try {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

			user.setFirstName(user.getFirstName());
			user.setLastName(user.getLastName());
			user.setAddress(user.getAddress());
			user.setPhone(user.getPhone());
			userRepository.save(user);

		} catch (Exception e) {
			throw new RuntimeException("Error updating user: " + e.getMessage());
		}
	}

	@Transactional(readOnly = false)
	public void changePasswordById(Integer id, ChangePasswordRequest changePassword) {
		try {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

			if (!passwordEncoder.matches(changePassword.getOldPassword(), user.getPassword())) {
				throw new RuntimeException("Old password does not match");
			}

			user.setPassword(passwordEncoder.encode(changePassword.getNewPassword()));
			userRepository.save(user);
			
		} catch (Exception e) {
			throw new RuntimeException("Error updating user password: " + e.getMessage());
		}
	}
	
	@Transactional(readOnly = false)
	public void create(UserCreateRequest dto) {
		try {
			User user = new User();
			
            user.setAddress(dto.getAddress());
            user.setEmail(dto.getEmail());
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setPhone(dto.getPhone());
			user.setPassword(passwordEncoder.encode(dto.getPassword()));
			userRepository.save(user);
			
		} catch (Exception e) {
			throw new RuntimeException("Error create user: " + e.getMessage());
		}
	}
}
