package com.cloud.organizationservice.repositories;

import com.cloud.organizationservice.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
