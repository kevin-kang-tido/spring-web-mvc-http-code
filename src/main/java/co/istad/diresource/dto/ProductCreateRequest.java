package co.istad.diresource.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jdk.jfr.Name;

public record ProductCreateRequest
        (
               @NotBlank
                String name,
                @Positive
                @NotNull
                Double price,
                @NotNull
               @Positive
               @Max(100)
                Integer qty


        ){


}
