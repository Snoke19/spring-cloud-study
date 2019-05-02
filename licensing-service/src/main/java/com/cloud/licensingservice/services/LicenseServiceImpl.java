package com.cloud.licensingservice.services;

import com.cloud.licensingservice.models.License;
import com.cloud.licensingservice.models.LicenseDTO;
import com.cloud.licensingservice.models.LicenseOrgDTO;
import com.cloud.licensingservice.models.organization.OrganizationDTO;
import com.cloud.licensingservice.repository.LicenseRepository;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Random;

@Service
@DefaultProperties(commandProperties =
        {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
public class LicenseServiceImpl implements LicenseService {

  private final LicenseRepository licenseRepository;
  private final RestTemplate restTemplate;

  public LicenseServiceImpl(LicenseRepository licenseRepository, RestTemplate restTemplate) {
    this.licenseRepository = licenseRepository;
    this.restTemplate = restTemplate;
  }

  @Override
  @Transactional
  @HystrixCommand(fallbackMethod = "buildFallbackLicenseList")
  public LicenseOrgDTO getLicense(int organizationId, int licenseId) {

    randomlyRunLong();

    OrganizationDTO organizationDTO = restTemplate.getForEntity("http://organizationservice/organization-service/organization/" + organizationId, OrganizationDTO.class).getBody();

    License license = licenseRepository.findById(licenseId).orElse(License.builder().licenseId(1).productName("test").date(LocalDateTime.now()).build());

    return LicenseOrgDTO.builder()
            .license(LicenseDTO.builder().licenseId(license.getLicenseId()).productName(license.getProductName()).date(license.getDate()).build())
            .organization(organizationDTO).build();
  }

  private LicenseOrgDTO buildFallbackLicenseList(int organizationId, int licenseId){

    License license = License.builder()
            .licenseId(12)
            .date(LocalDateTime.now())
            .productName("1000 protect").build();

    return LicenseOrgDTO.builder()
            .license(LicenseDTO.builder().licenseId(license.getLicenseId()).productName(license.getProductName()).date(license.getDate()).build())
            .organization(OrganizationDTO.builder().name("Sorry no licensing information currently available").build()).build();
  }

  private void randomlyRunLong() {
    Random rand = new Random();
    int randomNum = rand.nextInt((3 - 1) + 1) + 1;
    if (randomNum==3) sleep();
  }

  private void sleep(){
    try {
      Thread.sleep(13000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
