package com.areska.user.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse{	
	   private Integer userId;
	   private String firstName;
	   private String lastName;
	   private String email;
	   private String phone;
	   private String address;
	   private LocalDateTime createdAt;
}