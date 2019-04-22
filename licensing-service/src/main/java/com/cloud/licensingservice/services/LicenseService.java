package com.cloud.licensingservice.services;

import com.cloud.licensingservice.models.License;
import com.cloud.licensingservice.repository.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {

  private final LicenseRepository licenseRepository;

  public LicenseService(LicenseRepository licenseRepository) {
    this.licenseRepository = licenseRepository;
  }

  public License getLicense(String organizationId, String licenseId) {
    return licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
  }

  public List<License> getLicensesByOrg(String organizationId){
    return licenseRepository.findByOrganizationId( organizationId );
  }

  public void saveLicense(License license){
    license.setLicenseId( UUID.randomUUID().toString());
    licenseRepository.save(license);
  }

}
