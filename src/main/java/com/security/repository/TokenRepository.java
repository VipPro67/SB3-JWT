package com.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.security.entity.Token;

public interface TokenRepository extends MongoRepository<Token, String> {

  @Query("{ 'user.id' : ?0, 'revoked' : false, 'expired' : false }")
  List<Token> findAllValidTokenByUser(String id);

  @Query("{ 'token' : ?0, 'revoked' : false, 'expired' : false }")
  Optional<Token> findByToken(String token);
}
