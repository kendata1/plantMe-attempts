package bg.softuni.plantMe_attempts.web;

import bg.softuni.plantMe_attempts.models.PlantingAttemptDTO;
import bg.softuni.plantMe_attempts.service.PlantingAttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/attempts")
public class PlantingAttemptController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlantingAttemptController.class);
    private final PlantingAttemptService plantingAttemptService;

    public PlantingAttemptController(PlantingAttemptService plantingAttemptService) {
        this.plantingAttemptService = plantingAttemptService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantingAttemptDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok(plantingAttemptService.getPlantingAttemptById(id));
    }
    @GetMapping("/{username}/all")
    public ResponseEntity<List<PlantingAttemptDTO>> getAllPlantAttemptsForUser (@PathVariable("username") String username) {
        return ResponseEntity.ok(plantingAttemptService.getAllPlantingAttemptsForUser(username));
    }

    @PostMapping("/add")
    public ResponseEntity<PlantingAttemptDTO> createPlantingAttempt (
            @RequestBody PlantingAttemptDTO plantingAttemptDTO) {
        LOGGER.info("Going to create Planting attempt {}", plantingAttemptDTO);
        plantingAttemptService.addPlantingAttempt(plantingAttemptDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlantingAttemptDTO> deleteById(@PathVariable("id") Long id) {
        plantingAttemptService.deleteOffer(id);
        return ResponseEntity.ok().build();
    }

}