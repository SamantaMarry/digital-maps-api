package com.digitalmaps.api.repository;

import com.digitalmaps.api.entity.*;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalTime;
import java.util.List;

public interface PointOfInterestRepository extends MongoRepository<PointOfInterest, String> {

    List<PointOfInterest> findByLocationNear(Point point, Distance distance);

}
