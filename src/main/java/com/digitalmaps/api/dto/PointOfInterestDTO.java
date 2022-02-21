package com.digitalmaps.api.dto;

import com.digitalmaps.api.entity.PointOfInterest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointOfInterestDTO {

    private String name;
    private LocalTime opened;
    private LocalTime closed;
    private Boolean isOpened;
    private Integer latitude;
    private Integer longitude;


    private static boolean isOpened(LocalTime hours, PointOfInterest pointOfInterest) {
        if (Objects.isNull(pointOfInterest.getOpened()) ||
                pointOfInterest.getOpened().isBefore(hours) && pointOfInterest.getClosed().isAfter(hours)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }




}
