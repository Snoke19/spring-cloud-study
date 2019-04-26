package com.cloud.licensingservice.repository;

import com.cloud.licensingservice.models.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, Integer> {
}
