package com.example.Mappings.mapper;

import com.example.Mappings.dto.ProfileDto;
import com.example.Mappings.dto.UserDto;
import com.example.Mappings.entity.Profile;
import com.example.Mappings.entity.User;

public class UserMapper {

	public static User toEntity(UserDto dto) {
		if(dto == null) return null;
		
		Profile profile = new Profile();
		profile.setPhone(dto.getProfile().getPhoneNumber());
		profile.setEmail(dto.getProfile().getAddress());
		
		User user = new User();
		user.setName(dto.getName());
		user.setProfile(profile);
		return user;
	}
	
	public static UserDto toDto(User entity) {
		if(entity == null) return null;
		
		ProfileDto profileDto = new ProfileDto();
		profileDto.setPhoneNumber(entity.getProfile().getPhone());
		profileDto.setAddress(entity.getProfile().getEmail());
		
		UserDto userDto = new UserDto();
		userDto.setName(entity.getName());
		userDto.setProfile(profileDto);
		return userDto;
	}
	
	
}
