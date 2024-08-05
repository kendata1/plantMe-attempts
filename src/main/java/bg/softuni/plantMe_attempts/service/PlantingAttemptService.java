package bg.softuni.plantMe_attempts.service;
import bg.softuni.plantMe_attempts.models.PlantingAttemptDTO;

import java.util.List;

public interface PlantingAttemptService {
    void addPlantingAttempt (PlantingAttemptDTO addPlantingAttemptDTO);
    List<PlantingAttemptDTO> getAllPlantingAttemptsOfOthers (String username);
    List<PlantingAttemptDTO> getAllPlantingAttemptsForUser (String username);

    void deleteOffer(Long offerId);

    PlantingAttemptDTO getPlantingAttemptById(Long id);
}
