package service.impl;

import com.digitalmaps.api.dto.LocalizationDTO;
import com.digitalmaps.api.dto.PointOfInterestDTO;
import entity.PointOfInterest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import service.PointOfInterestService;

import java.time.LocalTime;
import java.util.List;

public class PointOfInterestServiceImpl implements PointOfInterestService {

    @Override
    public List<PointOfInterest> findAll() {
        return null;
    }

    @Override
    public List<PointOfInterest> findNearest(Point point, Distance distance, LocalTime hours) {
        return null;
    }

    @Override
    public PointOfInterest save(PointOfInterestDTO pointOfInterestDTO, LocalizationDTO localizationDTO) {
        return null;
    }
}
