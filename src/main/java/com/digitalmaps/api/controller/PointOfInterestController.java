package com.digitalmaps.api.controller;

import com.digitalmaps.api.dto.*;
import com.digitalmaps.api.mapper.PointOfInterestMapper;
import com.digitalmaps.api.request.PointOfInterestRequest;
import com.digitalmaps.api.response.PointOfInterestNearResponse;
import com.digitalmaps.api.response.PointOfInterestResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.digitalmaps.api.service.*;


import javax.validation.Valid;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/interest-point")
@AllArgsConstructor
public class PointOfInterestController {

    private PointOfInterestService service;

    @GetMapping
    public List<PointOfInterestResponse> findAll(){
        log.info("Fetching interest points");
        return service.findAll().stream()
                .map(PointOfInterestMapper::mapResponse)
                .collect(Collectors.toList());
    }


    @GetMapping("/nearest")
    public List<PointOfInterestNearResponse> findNearest(
            @RequestParam(value = "latitude") String latitude,
            @RequestParam(value = "longitude") String longitude,
            @RequestParam(value = "distanceInMeters") double distanceInMeters,
            @RequestParam(value = "hours") LocalTime hours) {
        log.info("Fetching nearest interest points by latitude: {}, longitude: {}, distanceInMeters: {}, hours: {}", latitude, longitude, distanceInMeters, hours);
        Point point = new Point(Double.parseDouble(latitude), Double.parseDouble(longitude));
        Distance distance = new Distance(distanceInMeters / 1000, Metrics.KILOMETERS);

        return service.findNearest(point, distance, hours).stream()
                .map(PointOfInterestMapper::mapNearResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PointOfInterestResponse save (@Valid @RequestBody PointOfInterestRequest pointOfInterestRequest){
        log.info("Creating interest point");
        PointOfInterestDTO seved = service.save(PointOfInterestMapper.mapRequest(pointOfInterestRequest));
        return PointOfInterestMapper.mapResponse(seved);

    }


}
