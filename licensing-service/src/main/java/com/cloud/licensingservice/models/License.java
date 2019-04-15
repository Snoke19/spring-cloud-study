package com.cloud.licensingservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class License {

  private String id;
  private String organizationId;
  private String productName;
  private String licenseType;
}
