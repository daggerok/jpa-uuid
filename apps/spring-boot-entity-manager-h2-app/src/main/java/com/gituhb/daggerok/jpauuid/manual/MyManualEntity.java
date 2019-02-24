package com.gituhb.daggerok.jpauuid.manual;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.TemporalType.*;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(staticName = "of")
public class MyManualEntity {

  @Id
  @Column(nullable = false)
  UUID id;

  @Column(nullable = false)
  String message;

  @Temporal(DATE)
  Date createdAt;

  @Temporal(TIME)
  Date modifiedAt;

  @Temporal(TIMESTAMP)
  Date timestamp;

  public static MyManualEntity of(UUID id, String message) {
    Date value = new Date();
    Date createdAt = new Date(value.getTime());
    Date modifiedAt = new Date(value.getTime());
    Date timestamp = new Date(value.getTime());
    return MyManualEntity.of(id, message, createdAt, modifiedAt, timestamp);
  }

  @PreUpdate
  public void preUpdate() {
    Date value = new Date();
    modifiedAt = new Date(value.getTime());
    timestamp = new Date(value.getTime());
  }
}
