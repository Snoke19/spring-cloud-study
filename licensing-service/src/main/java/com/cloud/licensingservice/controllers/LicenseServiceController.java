package com.cloud.licensingservice.controllers;

import com.cloud.licensingservice.models.License;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

  @RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
  public License getLicenses(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId) {

    return License.builder()
            .licenseId(licenseId)
            .productName("Teleco")
            .organizationId("TestOrg").build();
  }

}
