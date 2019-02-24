package com.gituhb.daggerok.jpauuid.manual;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MyManualRepository extends JpaRepository<MyManualEntity, UUID> { }
