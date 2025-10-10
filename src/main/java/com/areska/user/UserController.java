package com.areska.user;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.areska.shared.api.ApiSuccess;
import com.areska.user.dto.request.ChangePasswordRequest;
import com.areska.user.dto.request.UserCreateRequest;
import com.areska.user.dto.request.UserUpdateRequest;
import com.areska.user.dto.response.UserResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Operations related to users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "List all users")
    public ResponseEntity<ApiSuccess<List<UserResponse>>> list() {
        List<UserResponse> users = userService.getList();
        ApiSuccess<List<UserResponse>> response = new ApiSuccess<>(
                users.isEmpty() ? "No users found" : "Users listed successfully",
                users
        );
        HttpStatus status = users.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID")
    public ResponseEntity<ApiSuccess<UserResponse>> get(@PathVariable Integer id) {
        UserResponse user = userService.getById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return ResponseEntity.ok(new ApiSuccess<>("User found", user));
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    public ResponseEntity<ApiSuccess<Void>> create(@Valid @RequestBody UserCreateRequest request) {
        userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiSuccess<>("User created successfully", null));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a user by ID")
    public ResponseEntity<ApiSuccess<Void>> update(@PathVariable Integer id,
                                                   @Valid @RequestBody UserUpdateRequest request) {
        userService.editById(id, request);
        return ResponseEntity.ok(new ApiSuccess<>("User updated successfully", null));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user by ID")
    public ResponseEntity<ApiSuccess<Void>> delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.ok(new ApiSuccess<>("User deleted successfully", null));
    }

    @PutMapping("/{id}/change-password")
    @Operation(summary = "Change password for a user by ID")
    public ResponseEntity<ApiSuccess<Void>> changePassword(@PathVariable Integer id,
                                                           @Valid @RequestBody ChangePasswordRequest request) {
        userService.changePasswordById(id, request);
        return ResponseEntity.ok(new ApiSuccess<>("Password changed successfully", null));
    }
}
