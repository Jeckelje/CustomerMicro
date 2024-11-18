package com.vsu.by.customermicro.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Customer Response DTO")
public record CustomerResponse(
        @Schema(description = "Unique identifier of the customer", example = "1")
        Long id,

        @Schema(description = "Customer name", example = "ООО Минская скотобойня")
        String customerName,

        @Schema(description = "Legal address of the customer", example = "ул. Ленина, д. 10, г. Минск, РБ")
        String legalAddress,

        @Schema(description = "Total number of projects associated with the customer", example = "12")
        Integer totalProjects,

        @Schema(description = "Number of projects completed by the customer", example = "8")
        Integer completedProjects
) {
}

