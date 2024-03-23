package co.istad.diresource.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotNull
        @Size(max = 40)
        String name,
        String description
) {
}
