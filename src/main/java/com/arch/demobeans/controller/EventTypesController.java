package com.arch.demobeans.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arch.demobeans.model.EventTypesRequest;
import com.arch.demobeans.model.EventTypesResponse;
import com.arch.demobeans.service.EventTypesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("events")
public class EventTypesController {

  private final EventTypesService eventTypesService;

  @GetMapping
  public List<EventTypesResponse> eventTypes() {
    return eventTypesService.getAll();
  }

  @PostMapping
  public EventTypesResponse addEventType(@RequestBody EventTypesRequest eventTypesRequest) {
    return eventTypesService.create(eventTypesRequest);
  }

}
