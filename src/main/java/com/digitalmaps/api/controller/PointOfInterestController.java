package com.digitalmaps.api.controller;

import com.digitalmaps.api.dto.*;
import com.digitalmaps.api.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.digitalmaps.api.service.*;


import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/interest-point")
@AllArgsConstructor
public class PointOfInterestController {

    @Autowired
    private PointOfInterestService service;



    @GetMapping
    public List<PointOfInterest> findAll(){
        return service.findAll();
    }


    @GetMapping("/nearest")
    public List<PointOfInterest> findNearest(@RequestParam(value = "latitude") String latitude,
                                             @RequestParam(value = "longitude") String longitude,
                                             @RequestParam(value = "distanceInMeters") double distanceInMeters,
                                             @RequestParam(value = "hours") LocalTime hours){
        Point point = new Point(Double.parseDouble(latitude), Double.parseDouble(longitude));
        Distance distance = new Distance(distanceInMeters / 1000, Metrics.KILOMETERS);

        return service.findNearest(point, distance, hours);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PointOfInterest save (@RequestBody PointOfInterestDTO pointOfInterestDTO){
        return service.save(pointOfInterestDTO);

    }


}
