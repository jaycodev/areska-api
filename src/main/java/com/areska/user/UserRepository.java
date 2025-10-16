package com.areska.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.areska.user.dto.response.UserResponse;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT new com.areska.user.dto.response.UserResponse(u.id as userId, u.firstName as firstName, u.lastName as lastName, u.email as email, u.phone as phone, u.address as address, u.createdAt as createdAt) FROM User u")
	List<UserResponse> findAllWithoutPassword();
	
	@Query("SELECT new com.areska.user.dto.response.UserResponse(u.id as userId, u.firstName as firstName, u.lastName as lastName, u.email as email, u.phone as phone, u.address as address, u.createdAt as createdAt) FROM User u where u.id = :userId")
	Optional<UserResponse> findByIdWithoutPassword( @Param("userId") Integer userId);
	
}

/*	   private Integer userId;
private String firstName;
private String lastName;
private String email;
private String phone;
private String address;
private LocalDateTime createdAt;*/