package com.security.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.security.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

  @Query("{ 'email' : ?0 }")
  Optional<User> findByEmail(String email);

}
