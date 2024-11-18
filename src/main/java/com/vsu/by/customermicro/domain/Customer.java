package com.vsu.by.customermicro.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customers")
@Schema(description = "Customer entity info")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id", example = "3")
    private Long id;

    @Column(nullable = false, name = "customer_name", length = 100)
    @Schema(description = "Customer name", example = "ООО Минская скотобойня")
    private String customerName;

    @Column(nullable = false, name = "legal_address", length = 255)
    @Schema(description = "Legal address of customer", example = "ул. Ленина, д. 10, г. Минск, РБ")
    private String legalAddress;

    @Column(nullable = false)
    @Schema(description = "total number of projects", example = "4")
    private Integer totalProjects;

    @Column(nullable = false)
    @Schema(description = "number of completed projects")
    private Integer completedProjects;

}
