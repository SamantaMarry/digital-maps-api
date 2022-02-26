package com.digitalmaps.api.util;

import com.digitalmaps.api.dto.PointOfInterestDTO;


import java.time.LocalTime;

public class PointOfInterestCreator {

    public static PointOfInterestDTO mapRequest() {
        return PointOfInterestDTO.builder()
                .name("Posto de Combustivel")
                .opened(LocalTime.of(8, 00))
                .closed(LocalTime.of(18, 00))
                .latitude(31)
                .longitude(18)
                .build();
    }

    public static PointOfInterestDTO mapRequestId() {
        return PointOfInterestDTO.builder()
                .id("62195c233d9b1569e97bb607")
                .name("Posto de Combustivel")
                .opened(LocalTime.of(8, 00))
                .closed(LocalTime.of(18, 00))
                .latitude(31)
                .longitude(18)
                .build();
    }

}

