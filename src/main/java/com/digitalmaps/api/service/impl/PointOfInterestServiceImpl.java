package com.digitalmaps.api.service.impl;


import com.digitalmaps.api.dto.PointOfInterestDTO;
import com.digitalmaps.api.entity.PointOfInterest;
import com.digitalmaps.api.mapper.PointOfInterestMapper;
import com.digitalmaps.api.repository.PointOfInterestRepository;
import com.digitalmaps.api.service.PointOfInterestService;
import lombok.AllArgsConstructor;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PointOfInterestServiceImpl implements PointOfInterestService {

    private PointOfInterestRepository pointOfInterestRepository;


    @Override
    public List<PointOfInterestDTO> findAll() {
        return this.pointOfInterestRepository.findAll().stream()
                .map(PointOfInterestMapper::mapDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PointOfInterestDTO> findNearest(Point point, Distance distance, LocalTime hours) {
        return pointOfInterestRepository.findByLocationNear(point, distance).stream()
                .map(pointOfInterest -> PointOfInterestMapper.mapDTO(pointOfInterest, hours))
                .collect(Collectors.toList());
    }

    @Override
    public PointOfInterestDTO save(PointOfInterestDTO pointOfInterestDTO) {
        PointOfInterest entity = PointOfInterestMapper.mapEntity(pointOfInterestDTO);
        return PointOfInterestMapper.mapDTO(pointOfInterestRepository.save(entity));

    }

}
