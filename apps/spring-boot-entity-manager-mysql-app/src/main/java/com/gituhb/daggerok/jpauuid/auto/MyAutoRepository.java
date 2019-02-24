package com.gituhb.daggerok.jpauuid.auto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyAutoRepository {

  final EntityManager entityManager;

  public Collection<MyAutoEntity> findAll() {
    return entityManager.createQuery("select mae from MyAutoEntity mae", MyAutoEntity.class)
                        .getResultList();
  }

  @Transactional
  public MyAutoEntity save(MyAutoEntity entity) {
    entityManager.persist(entity);
    return entity;
  }
}
