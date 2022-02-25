package com.digitalmaps.api.service;

import com.digitalmaps.api.dto.*;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.time.LocalTime;
import java.util.List;

public interface PointOfInterestService {
    List<PointOfInterestDTO> findAll();
    List<PointOfInterestDTO> findNearest(Point point, Distance distance, LocalTime hours);
    PointOfInterestDTO save (PointOfInterestDTO pointOfInterestDTO);

}
