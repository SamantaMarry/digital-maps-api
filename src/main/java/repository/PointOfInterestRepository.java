package repository;

import entity.PointOfInterest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PointOfInterestRepository extends MongoRepository<PointOfInterest, String> {

    List<PointOfInterest> findByLocationNear (Point point, Distance distance);

}
