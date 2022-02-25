package com.digitalmaps.api.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointOfInterestRequest {

    private String name;
    private Integer latitude;
    private Integer longitude;
    private LocalTime opened;
    private LocalTime closed;
}

