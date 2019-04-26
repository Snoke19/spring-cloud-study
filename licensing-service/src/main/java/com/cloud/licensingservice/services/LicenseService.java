package com.cloud.licensingservice.services;

import com.cloud.licensingservice.models.LicenseOrgDTO;

public interface LicenseService {

  LicenseOrgDTO getLicense(int organizationId, int licenseId);

}
