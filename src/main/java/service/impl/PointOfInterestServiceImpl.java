package service.impl;

import dto.PointOfInterestDTO;
import entity.PointOfInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;
import repository.PointOfInterestRepository;
import service.PointOfInterestService;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
public class PointOfInterestServiceImpl implements PointOfInterestService {

    @Autowired
    private PointOfInterestRepository pointOfInterestRepository;



    @Override
    public List<PointOfInterest> findAll() {
        return this.pointOfInterestRepository.findAll();
    }

    @Override
    public List<PointOfInterest> findNearest(Point point, Distance distance, LocalTime hours) {
        return this.pointOfInterestRepository.findByLocationNear(point, distance, hours);
    }

    @Override
    public PointOfInterest save(PointOfInterestDTO pointOfInterestDTO) {
        PointOfInterest pointOfInterest =
                PointOfInterest.builder()
                .name(pointOfInterestDTO.getName())
                .opened(pointOfInterestDTO.getOpened())
                .closed(pointOfInterestDTO.getClosed())
                .location(new GeoJsonPoint(Double.valueOf(pointOfInterestDTO.getLatitude()),
                                Double.valueOf(pointOfInterestDTO.getLongitude())))

                .build();
        return pointOfInterestRepository.save(pointOfInterest);





    }
}
