package com.digitalmaps.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointOfInterestResponse {
    private String id;
    private String name;
    private Integer latitude;
    private Integer longitude;
    private LocalTime opened;
    private LocalTime closed;

}
