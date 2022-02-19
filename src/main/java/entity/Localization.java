package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Localization {

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    @DBRef
    private GeoJsonPoint location;

}