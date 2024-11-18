package com.vsu.by.customermicro.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.validation.constraints.Min;

@Schema(description = "Create Customer Request DTO")
public record CreateCustomerRequest
        (
                @NotNull(message = "{customer.customer_name.notnull}")
                @Size(min = 2, max = 100, message = "{customer.customer_name.size}")
                @Schema(description = "Customer Name", example = "ООО Минская скотобойня")
                String customerName,

                @NotNull(message = "customer.legal_address.notnull")
                @Size(min = 2, max = 255, message = "{customer.legal_address.size}")
                @Schema(description = "Legal Address", example = "ул. Ленина, д. 10, г. Минск, РБ")
                String legalAddress,

                @NotNull(message = "{customer.total_projects.notnull}")
                @Min(value = 0, message = "{customer.total_projects.min}")
                @Schema(description = "Total number of projects associated with the customer", example = "10")
                Integer totalProjects,

                @NotNull(message = "{customer.completed_projects.notnull}")
                @Min(value = 0, message = "{customer.completed_projects.min}")
                @Schema(description = "Number of completed projects by the customer", example = "5")
                Integer completedProjects
        ) {
    public CreateCustomerRequest {
        // Validation: Completed projects cannot exceed total projects
        if (completedProjects != null && totalProjects != null && completedProjects > totalProjects) {
            throw new IllegalArgumentException("Completed projects cannot exceed total projects.");
        }
    }
}

