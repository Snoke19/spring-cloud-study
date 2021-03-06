package com.cloud.licensingservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "licenses")
public class License implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_license", nullable = false)
  private int licenseId;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "date")
  private LocalDateTime date;
}
