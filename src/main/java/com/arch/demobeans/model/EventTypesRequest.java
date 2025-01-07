package com.arch.demobeans.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EventTypesRequest {

  private String name;
  private String nameInEnglish;
  private String disclaimerMsg;
  private boolean enabled;

}
