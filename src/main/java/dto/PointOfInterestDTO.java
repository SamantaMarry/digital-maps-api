package dto;

import entity.PointOfInterest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

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
