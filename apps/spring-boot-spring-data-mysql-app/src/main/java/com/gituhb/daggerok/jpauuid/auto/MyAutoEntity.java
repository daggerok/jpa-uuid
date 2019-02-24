package com.gituhb.daggerok.jpauuid.auto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.TemporalType.*;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor(staticName = "of")
public class MyAutoEntity {

  @Id
  @NonNull
  @Column(nullable = false)
  UUID id;

  @NonNull
  @Column(nullable = false)
  String message;

  @Temporal(DATE)
  Date createdAt;

  @Temporal(TIME)
  Date modifiedAt;

  @Temporal(TIMESTAMP)
  Date timestamp;

  @PrePersist
  public void prePersist() {
    Date value = new Date();
    createdAt = new Date(value.getTime());
    modifiedAt = new Date(value.getTime());
    timestamp = new Date(value.getTime());
  }

  @PreUpdate
  public void preUpdate() {
    Date value = new Date();
    modifiedAt = new Date(value.getTime());
    timestamp = new Date(value.getTime());
  }
}
