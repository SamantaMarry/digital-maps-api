package com.digitalmaps.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder (toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PointOfInterestDTO {
    private String id;
    private String name;
    private LocalTime opened;
    private LocalTime closed;
    private Boolean isOpened;
    private Integer latitude;
    private Integer longitude;
}
