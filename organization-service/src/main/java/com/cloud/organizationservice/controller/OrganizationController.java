package com.cloud.organizationservice.controller;

import com.cloud.organizationservice.models.Organization;
import com.cloud.organizationservice.services.OrganizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {

  private final OrganizationService organizationService;

  public OrganizationController(OrganizationService organizationService) {
    this.organizationService = organizationService;
  }

  @GetMapping("/organization/{organizationId}")
  public Organization getAllOrganization(@PathVariable("organizationId") int organizationId) {
    return this.organizationService.getOne(organizationId);
  }
}
