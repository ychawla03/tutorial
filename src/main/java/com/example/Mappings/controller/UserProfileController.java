package com.example.Mappings.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mappings.dto.UserDto;
import com.example.Mappings.entity.User;
import com.example.Mappings.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Tag(name = "User Profile API", description="CRUD for User-Profile Relationship")
public class UserProfileController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/users")
    @Operation(summary = "Post user data", description = "Returns list of user added")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User saved = userRepository.save(user);
        UserDto responseDto = modelMapper.map(saved, UserDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

}
