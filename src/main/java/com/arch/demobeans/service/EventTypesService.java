package com.arch.demobeans.service;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.arch.demobeans.model.EventTypesEntity;
import com.arch.demobeans.model.EventTypesRequest;
import com.arch.demobeans.model.EventTypesResponse;
import com.arch.demobeans.repository.EventTypesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventTypesService {

  private static final Logger log = LoggerFactory.getLogger(EventTypesService.class);
  private final EventTypesRepository eventTypesRepository;

  @CacheEvict(value = {"eventTypes", "event-types"}, allEntries = true)
  public EventTypesResponse create(EventTypesRequest eventTypesRequest) {
    log.info("EventTypesRequest: {}", eventTypesRequest);
    EventTypesEntity entity = new EventTypesEntity();
    entity.setName(eventTypesRequest.getName());
    entity.setEnabled(eventTypesRequest.isEnabled());
    entity.setDisclaimerMsg(eventTypesRequest.getDisclaimerMsg());
    entity.setNameInEnglish(eventTypesRequest.getNameInEnglish());
    eventTypesRepository.save(entity);
    return createResponse(entity);
  }

  @Cacheable(value = "eventTypes")
  public List<EventTypesResponse> getAll() {
    log.info("Read data from database");
    return eventTypesRepository.findAll().stream().map(this::createResponse).toList();
  }

  @NotNull
  private EventTypesResponse createResponse(EventTypesEntity entity) {
    EventTypesResponse response = new EventTypesResponse();
    response.setId(entity.getEventTypeId());
    response.setName(entity.getName());
    response.setEnabled(entity.isEnabled());
    response.setDisclaimerMsg(entity.getDisclaimerMsg());
    response.setNameInEnglish(entity.getNameInEnglish());
    response.setCreatedAt(entity.getCreatedAt());
    response.setUpdatedAt(entity.getUpdatedAt());
    response.setVersion(entity.getVersion());
    return response;
  }

}
