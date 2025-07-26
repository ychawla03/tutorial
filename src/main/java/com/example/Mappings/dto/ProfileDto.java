package com.example.Mappings.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfileDto {

	@NotBlank
	private String address;
	
	@NotBlank
	private String phoneNumber;
	
}
