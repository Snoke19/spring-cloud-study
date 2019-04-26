package com.cloud.licensingservice.services;

import com.cloud.licensingservice.models.License;
import com.cloud.licensingservice.models.LicenseDTO;
import com.cloud.licensingservice.models.LicenseOrgDTO;
import com.cloud.licensingservice.models.organization.OrganizationDTO;
import com.cloud.licensingservice.repository.LicenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class LicenseServiceImpl implements LicenseService {

  private final LicenseRepository licenseRepository;
  private final RestTemplate restTemplate;

  public LicenseServiceImpl(LicenseRepository licenseRepository, RestTemplate restTemplate) {
    this.licenseRepository = licenseRepository;
    this.restTemplate = restTemplate;
  }

  @Override
  @Transactional
  public LicenseOrgDTO getLicense(int organizationId, int licenseId) {

    OrganizationDTO organizationDTO = restTemplate.getForEntity("http://organizationservice/organization-service/organization", OrganizationDTO.class, organizationId).getBody();

    License license = licenseRepository.findById(licenseId).orElse(License.builder().licenseId(1).productName("test").date(LocalDateTime.now()).build());

    return LicenseOrgDTO.builder()
            .license(LicenseDTO.builder().licenseId(license.getLicenseId()).productName(license.getProductName()).date(license.getDate()).build())
            .organization(organizationDTO).build();
  }
}
