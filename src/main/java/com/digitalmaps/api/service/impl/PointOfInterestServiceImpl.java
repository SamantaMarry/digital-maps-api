package com.digitalmaps.api.service.impl;


import com.digitalmaps.api.dto.PointOfInterestDTO;
import com.digitalmaps.api.entity.PointOfInterest;
import com.digitalmaps.api.repository.PointOfInterestRepository;
import com.digitalmaps.api.service.PointOfInterestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;


@Service
@AllArgsConstructor
public class PointOfInterestServiceImpl implements PointOfInterestService {

    @Autowired
    private PointOfInterestRepository pointOfInterestRepository;



    @Override
    public List<PointOfInterest> findAll() {
        return this.pointOfInterestRepository.findAll();
    }

    @Override
    public List<PointOfInterest> findNearest(Point point, Distance distance, LocalTime hours) {
       return pointOfInterestRepository.findByLocationNear(point, distance);


    }

    @Override
    public PointOfInterest save(PointOfInterestDTO pointOfInterestDTO) {
        PointOfInterest pointOfInterest =
                PointOfInterest.builder()
                .name(pointOfInterestDTO.getName())
                .opened(pointOfInterestDTO.getOpened())
                .closed(pointOfInterestDTO.getClosed())
                .location(new GeoJsonPoint
                        (Double.valueOf(pointOfInterestDTO.getLatitude()),
                         Double.valueOf(pointOfInterestDTO.getLongitude())))

                .build();
        return pointOfInterestRepository.save(pointOfInterest);





    }






}
