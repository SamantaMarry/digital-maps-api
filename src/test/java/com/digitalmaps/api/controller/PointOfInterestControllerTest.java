package com.digitalmaps.api.controller;


import com.digitalmaps.api.response.PointOfInterestResponse;
import com.digitalmaps.api.service.PointOfInterestService;
import com.digitalmaps.api.util.PointOfInterestCreator;
import com.digitalmaps.api.util.PointOfInterestRequestBodyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
class PointOfInterestControllerTest {

    @InjectMocks
    private PointOfInterestController pointOfInterestController;
    @Mock
    private PointOfInterestService pointOfInterestServiceMock;

    @BeforeEach
    void setUp(){
        BDDMockito.when(pointOfInterestServiceMock.findAll())
                .thenReturn(List.of(PointOfInterestCreator.mapRequest()));

        BDDMockito.when(pointOfInterestServiceMock.save(ArgumentMatchers.any()))
                .thenReturn(PointOfInterestCreator.mapRequestId());


       /* List<PointOfInterestNearResponse> listPointNear =
                List.of(PointOfInterestNearResponseCreator.mapResponse(PointOfInterestCreator.mapRequest()));

        BDDMockito.when(pointOfInterestServiceMock.findNearest(ArgumentMatchers.any()))
                .thenReturn(listPointNear);*/
    }

    @Test
    @DisplayName(" Returns list of point when successful")
    void findAllPoints(){
        String expectedName = PointOfInterestCreator.mapRequest().getName();
        LocalTime expectedOpened = PointOfInterestCreator.mapRequest().getOpened();
        LocalTime expectedClosed = PointOfInterestCreator.mapRequest().getClosed();
        Integer expectedLatitude = PointOfInterestCreator.mapRequest().getLatitude();
        Integer expectedLongitude = PointOfInterestCreator.mapRequest().getLongitude();

        List<PointOfInterestResponse> pointList = pointOfInterestController.findAll();

        Assertions.assertThat(pointList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(pointList.get(0).getName()).isEqualTo(expectedName);
        Assertions.assertThat(pointList.get(0).getOpened()).isEqualTo(expectedOpened);
        Assertions.assertThat(pointList.get(0).getClosed()).isEqualTo(expectedClosed);
        Assertions.assertThat(pointList.get(0).getLatitude()).isEqualTo(expectedLatitude);
        Assertions.assertThat(pointList.get(0).getLongitude()).isEqualTo(expectedLongitude);

    }

    @Test
    @DisplayName(" Save returns point when successful")
    void SavePoint(){
        String expectedId = PointOfInterestCreator.mapRequestId().getId();
        String expectedName = PointOfInterestCreator.mapRequestId().getName();
        LocalTime expectedOpened = PointOfInterestCreator.mapRequestId().getOpened();
        LocalTime expectedClosed = PointOfInterestCreator.mapRequestId().getClosed();
        Integer expectedLatitude = PointOfInterestCreator.mapRequestId().getLatitude();
        Integer expectedLongitude = PointOfInterestCreator.mapRequestId().getLongitude();

        PointOfInterestResponse point = pointOfInterestController.save(PointOfInterestRequestBodyCreator
                .mapRequestBody());

        Assertions.assertThat(point)
                .isNotNull();

        Assertions.assertThat(point.getId()).isNotNull().isEqualTo(expectedId);
        Assertions.assertThat(point.getName()).isNotNull().isEqualTo(expectedName);
        Assertions.assertThat(point.getOpened()).isNotNull().isEqualTo(expectedOpened);
        Assertions.assertThat(point.getClosed()).isNotNull().isEqualTo(expectedClosed);
        Assertions.assertThat(point.getLatitude()).isNotNull().isEqualTo(expectedLatitude);
        Assertions.assertThat(point.getLongitude()).isNotNull().isEqualTo(expectedLongitude);

    }

    /*@Test
    @DisplayName("Returns list of point when successful")
    void ListPointsNear(){
        String expectedId = PointOfInterestNearResponse.mapResponse();
        String expectedName = PointOfInterestCreator.mapRequestId().getName();

        List<PointOfInterestNearResponse> pointList = pointOfInterestController.findNearest(null,
                null,
                0,
                null);

        Assertions.assertThat(pointList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(pointList.getId()).isNotNull().isEqualTo(expectedId);
        Assertions.assertThat(pointList.getName()).isNotNull().isEqualTo(expectedName);
        Assertions.assertThat(pointList.getOpened()).isNotNull().isEqualTo(expectedOpened);
        Assertions.assertThat(pointList.getClosed()).isNotNull().isEqualTo(expectedClosed);
        Assertions.assertThat(pointList.getLatitude()).isNotNull().isEqualTo(expectedLatitude);
        Assertions.assertThat(pointList.getLongitude()).isNotNull().isEqualTo(expectedLongitude);

    }*/

}