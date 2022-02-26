package com.digitalmaps.api.util;

import com.digitalmaps.api.request.PointOfInterestRequest;



public class PointOfInterestRequestBodyCreator {
    public static PointOfInterestRequest mapRequestBody() {
        return PointOfInterestRequest.builder()
                .name(PointOfInterestCreator.mapRequest().getName())
                .opened(PointOfInterestCreator.mapRequest().getOpened())
                .closed(PointOfInterestCreator.mapRequest().getClosed())
                .latitude(PointOfInterestCreator.mapRequest().getLatitude())
                .longitude(PointOfInterestCreator.mapRequest().getLongitude())
                .build();
    }


}
