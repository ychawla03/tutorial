package com.example.Mappings;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Mappings.dto.UserDto;
import com.example.Mappings.entity.User;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // DTO → Entity
        modelMapper.addMappings(new PropertyMap<UserDto, User>() {
            @Override
            protected void configure() {
                map().getProfile().setPhone(source.getProfile().getPhoneNumber());
                map().getProfile().setEmail(source.getProfile().getAddress());
            }
        });

        // Entity → DTO
        modelMapper.addMappings(new PropertyMap<User, UserDto>() {
            @Override
            protected void configure() {
                map().getProfile().setPhoneNumber(source.getProfile().getPhone());
                map().getProfile().setAddress(source.getProfile().getEmail());
            }
        });

        return modelMapper;
    }
}
