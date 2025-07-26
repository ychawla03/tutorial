package com.example.Mappings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mappings.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
