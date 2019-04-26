package com.cloud.organizationservice.services;

import com.cloud.organizationservice.models.Organization;
import com.cloud.organizationservice.repositories.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

  private final OrganizationRepository organizationRepository;

  public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  @Override
  public Organization getOne(int id) {
    return Organization.builder().id_organization(1).name("test").build();
  }
}
