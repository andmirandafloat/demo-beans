package com.arch.demobeans.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "event_types")
@EntityListeners(AuditingEntityListener.class)
public class EventTypesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int eventTypeId;
  private String name;
  private String nameInEnglish;
  private String disclaimerMsg;
  private boolean enabled;
  @CreatedDate
  private Instant createdAt;
  @LastModifiedDate
  private Instant UpdatedAt;
  @Version
  private int version;

}
