package com.cloud.licensingservice.controllers;

import com.cloud.licensingservice.models.LicenseOrgDTO;
import com.cloud.licensingservice.services.LicenseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenseServiceController {

  private final LicenseService licenseService;

  public LicenseServiceController(LicenseService licenseService) {
    this.licenseService = licenseService;
  }

  @RequestMapping(value="licenses/{licenseId}/organizations/{organizationId}",method = RequestMethod.GET)
  public LicenseOrgDTO getLicenses(@PathVariable("licenseId") int licenseId, @PathVariable("organizationId") int organizationId) {
    return this.licenseService.getLicense(organizationId, licenseId);
  }

}
