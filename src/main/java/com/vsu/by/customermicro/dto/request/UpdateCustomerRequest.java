package com.vsu.by.customermicro.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.validation.constraints.Min;

@Schema(description = "Update Customer Request Dto")
public record UpdateCustomerRequest
        (
                @NotNull(message = "{customer.customer_name.notnull}")
                @Size(min = 2, max = 100, message = "{customer.customer_name.size}")
                @Schema(description = "Updated customer's full name", example = "ООО Минская скотобойня")
                String customerName,

                @NotNull(message = "customer.legal_address.notnull")
                @Size(min = 2, max = 255, message = "{customer.legal_address.size}")
                @Schema(description = "Updated legal address of the customer", example = "ул. Ленина, д. 10, г. Минск, РБ")
                String legalAddress,

                @NotNull(message = "{customer.total_projects.notnull}")
                @Min(value = 0, message = "{customer.total_projects.min}")
                @Schema(description = "Updated total number of projects associated with the customer", example = "12")
                Integer totalProjects,

                @NotNull(message = "{customer.completed_projects.notnull}")
                @Min(value = 0, message = "{customer.completed_projects.min}")
                @Schema(description = "Updated number of completed projects by the customer", example = "8")
                Integer completedProjects
        ) {
    public UpdateCustomerRequest {
        // Validation: Completed projects cannot exceed total projects
        if (completedProjects != null && totalProjects != null && completedProjects > totalProjects) {
            throw new IllegalArgumentException("Completed projects cannot exceed total projects.");
        }
    }
}

