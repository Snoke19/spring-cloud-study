package com.cloud.licensingservice.models;

import com.cloud.licensingservice.models.organization.OrganizationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LicenseOrgDTO {

  private LicenseDTO license;
  private OrganizationDTO organization;
}
