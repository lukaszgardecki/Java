package com.example.przyklad_1.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskJpaRepo extends JpaRepository<TaskEntity, UUID> {
}
