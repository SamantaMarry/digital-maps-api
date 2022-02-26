package com.digitalmaps.api.util;

import com.digitalmaps.api.dto.PointOfInterestDTO;
import com.digitalmaps.api.enums.PointStatusEnum;
import com.digitalmaps.api.response.PointOfInterestNearResponse;


public class PointOfInterestNearResponseCreator {

    public static PointOfInterestNearResponse mapResponse(PointOfInterestDTO pointOfInterestDTO) {
        return PointOfInterestNearResponse.builder()
                .name("Posto de Combustivel")
                .status(pointOfInterestDTO.getIsOpened() ? PointStatusEnum.OPEN : PointStatusEnum.CLOSED)
                .build();
    }
}
