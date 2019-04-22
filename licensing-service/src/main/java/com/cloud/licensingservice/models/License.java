package com.cloud.licensingservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "licenses")
public class License {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "licenseId", nullable = false)
  private String licenseId;

  @Column(name = "organizationId", nullable = false)
  private String organizationId;

  @Column(name = "productName", nullable = false)
  private String productName;
}
