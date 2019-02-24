package com.gituhb.daggerok.jpauuid.manual;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyManualRepository {

  final EntityManager entityManager;

  public Collection<MyManualEntity> findAll() {
    return entityManager.createQuery("select mme from MyManualEntity mme", MyManualEntity.class)
                        .getResultList();
  }

  @Transactional
  public MyManualEntity save(MyManualEntity entity) {
    entityManager.persist(entity);
    return entity;
  }
}
