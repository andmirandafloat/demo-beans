package com.arch.demobeans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arch.demobeans.model.EventTypesEntity;

public interface EventTypesRepository extends JpaRepository<EventTypesEntity, Integer> {
}
