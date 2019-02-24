package com.gituhb.daggerok.jpauuid.auto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MyAutoRepository extends JpaRepository<MyAutoEntity, UUID> { }
