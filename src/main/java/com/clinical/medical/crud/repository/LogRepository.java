package com.clinical.medical.crud.repository;

import com.clinical.medical.crud.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer> {
}
