package repository;

import entity.Localization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocalizationRepository extends MongoRepository<Localization, String> {
}
