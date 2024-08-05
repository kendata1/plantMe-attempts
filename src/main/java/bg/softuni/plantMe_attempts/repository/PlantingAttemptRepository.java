package bg.softuni.plantMe_attempts.repository;

import bg.softuni.plantMe_attempts.models.PlantingAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantingAttemptRepository extends JpaRepository<PlantingAttempt, Long> {
    List<PlantingAttempt> getAllByUsernameOrderByPlantingDate (String username);

    List<PlantingAttempt> getAllByUsernameNotOrderByPlantingDate (String username);
}
