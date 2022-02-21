package service;

import dto.PointOfInterestDTO;
import entity.PointOfInterest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.time.LocalTime;
import java.util.List;

public interface PointOfInterestService {

    public List<PointOfInterest> findAll();

    public List<PointOfInterest> findNearest(Point point, Distance distance, LocalTime hours);

    public PointOfInterest save (PointOfInterestDTO pointOfInterestDTO);

}
