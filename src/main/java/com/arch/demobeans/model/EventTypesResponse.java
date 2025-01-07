package com.arch.demobeans.model;

import java.io.Serializable;
import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventTypesResponse implements Serializable {

  private int id;
  private String name;
  private String nameInEnglish;
  private String disclaimerMsg;
  private boolean enabled;
  private Instant createdAt;
  private Instant updatedAt;
  private int version;

}
