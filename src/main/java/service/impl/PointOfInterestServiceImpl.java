package service.impl;

import dto.LocalizationDTO;
import dto.PointOfInterestDTO;
import entity.Localization;
import entity.PointOfInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;
import repository.LocalizationRepository;
import repository.PointOfInterestRepository;
import service.LocalizationService;
import service.PointOfInterestService;

import java.time.LocalTime;
import java.util.List;

@Service
public class PointOfInterestServiceImpl implements PointOfInterestService {

    @Autowired
    private PointOfInterestRepository pointOfInterestRepository;


    private LocalizationService localizationService;


    @Override
    public List<PointOfInterest> findAll() {
        return this.pointOfInterestRepository.findAll();
    }

    @Override
    public List<PointOfInterest> findNearest(Point point, Distance distance, LocalTime hours) {
        return null;
    }

    @Override
    public PointOfInterest save(PointOfInterestDTO pointOfInterestDTO, LocalizationDTO localizationDTO) {
        PointOfInterest pointOfInterest = PointOfInterest.builder()
                .name(pointOfInterestDTO.getName())
                .opened(pointOfInterestDTO.getOpened())
                .closed(pointOfInterestDTO.getClosed())
                .build();
        return pointOfInterestRepository.save(pointOfInterest);


    }
}
