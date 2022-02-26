package com.digitalmaps.api.service.impl;


import com.digitalmaps.api.dto.PointOfInterestDTO;
import com.digitalmaps.api.entity.PointOfInterest;
import com.digitalmaps.api.mapper.PointOfInterestMapper;
import com.digitalmaps.api.repository.PointOfInterestRepository;
import com.digitalmaps.api.service.PointOfInterestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@AllArgsConstructor
public class PointOfInterestServiceImpl implements PointOfInterestService {

    private PointOfInterestRepository pointOfInterestRepository;


    @Override
    public List<PointOfInterestDTO> findAll() {
        log.info("Fething all interest points");
        return this.pointOfInterestRepository.findAll().stream()
                .map(PointOfInterestMapper::mapDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PointOfInterestDTO> findNearest(Point point, Distance distance, LocalTime hours) {
        log.info("Fetching interest points near to point: {}, in distance: {}", point, distance);
        return pointOfInterestRepository.findByLocationNear(point, distance).stream()
                .map(pointOfInterest -> PointOfInterestMapper.mapDTO(pointOfInterest, hours))
                .collect(Collectors.toList());
    }

    @Override
    public PointOfInterestDTO save(PointOfInterestDTO pointOfInterestDTO) {
        log.info("Saving interest point: {}", pointOfInterestDTO);
        PointOfInterest entity = PointOfInterestMapper.mapEntity(pointOfInterestDTO);
        return PointOfInterestMapper.mapDTO(pointOfInterestRepository.save(entity));

    }

}
