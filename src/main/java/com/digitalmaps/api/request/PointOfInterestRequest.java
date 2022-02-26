package com.digitalmaps.api.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointOfInterestRequest {
    @NotNull(message = "O nome do ponto de interesse é obrigatório")
    private String name;
    @Min(value = 0, message = "A latitude deve ser maior ou igual a 0")
    @NotNull(message = "A latitude do ponto de interesse é obrigatória")
    private Integer latitude;
    @Min(value = 0, message = "A longitude deve ser maior ou igual a 0")
    @NotNull(message = "A longitude do ponto de interesse é obrigatória")
    private Integer longitude;
    private LocalTime opened;
    private LocalTime closed;
}

