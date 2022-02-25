package com.digitalmaps.api.mapper;

import com.digitalmaps.api.dto.PointOfInterestDTO;
import com.digitalmaps.api.entity.PointOfInterest;
import com.digitalmaps.api.enums.PointStatusEnum;
import com.digitalmaps.api.request.PointOfInterestRequest;
import com.digitalmaps.api.response.PointOfInterestNearResponse;
import com.digitalmaps.api.response.PointOfInterestResponse;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.LocalTime;
import java.util.Objects;

public class PointOfInterestMapper {
    private PointOfInterestMapper() {}

    public static PointOfInterestResponse mapResponse(PointOfInterestDTO pointOfInterestDTO) {
        return PointOfInterestResponse.builder()
                .id(pointOfInterestDTO.getId())
                .name(pointOfInterestDTO.getName())
                .opened(pointOfInterestDTO.getOpened())
                .closed(pointOfInterestDTO.getClosed())
                .latitude(pointOfInterestDTO.getLatitude())
                .longitude(pointOfInterestDTO.getLongitude())
                .build();
    }

    public static PointOfInterestDTO mapRequest(PointOfInterestRequest pointOfInterestRequest) {
        return PointOfInterestDTO.builder()
                .name(pointOfInterestRequest.getName())
                .opened(pointOfInterestRequest.getOpened())
                .closed(pointOfInterestRequest.getClosed())
                .latitude(pointOfInterestRequest.getLatitude())
                .longitude(pointOfInterestRequest.getLongitude())
                .build();
    }

    public static PointOfInterest mapEntity(PointOfInterestDTO pointOfInterestDTO) {
        return PointOfInterest.builder()
                .id(pointOfInterestDTO.getId())
                .name(pointOfInterestDTO.getName())
                .closed(pointOfInterestDTO.getClosed())
                .opened(pointOfInterestDTO.getOpened())
                .location(new GeoJsonPoint(Double.valueOf(pointOfInterestDTO.getLatitude()), Double.valueOf(pointOfInterestDTO.getLongitude())))
                .build();
    }

    public static PointOfInterestNearResponse mapNearResponse(PointOfInterestDTO pointOfInterestDTO) {
        return PointOfInterestNearResponse.builder()
                .name(pointOfInterestDTO.getName())
                .status(pointOfInterestDTO.getIsOpened() ? PointStatusEnum.OPEN : PointStatusEnum.CLOSED)
                .build();
    }

    public static PointOfInterestDTO mapDTO(PointOfInterest pointOfInterest) {
        return PointOfInterestDTO.builder()
                .id(pointOfInterest.getId())
                .name(pointOfInterest.getName())
                .opened(pointOfInterest.getOpened())
                .closed(pointOfInterest.getClosed())
                .latitude(pointOfInterest.getLocation().getCoordinates().get(0).intValue())
                .longitude(pointOfInterest.getLocation().getCoordinates().get(1).intValue())
                .build();
    }

    public static PointOfInterestDTO mapDTO(PointOfInterest pointOfInterest, LocalTime hours) {
        return mapDTO(pointOfInterest).toBuilder()
                .isOpened(isOpened(hours, pointOfInterest))
                .build();
    }

    private static boolean isOpened(LocalTime hours, PointOfInterest pointOfInterest) {
        if (Objects.isNull(pointOfInterest.getOpened()) ||
                pointOfInterest.getOpened().isBefore(hours) && pointOfInterest.getClosed().isAfter(hours)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
