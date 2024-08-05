package bg.softuni.plantMe_attempts.service;

import bg.softuni.plantMe_attempts.models.PlantingAttemptDTO;
import bg.softuni.plantMe_attempts.models.PlantingAttempt;
import bg.softuni.plantMe_attempts.repository.PlantingAttemptRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantingAttemptServiceImpl implements PlantingAttemptService{
    @Override
    public PlantingAttemptDTO getPlantingAttemptById(Long id) {
        PlantingAttempt plantingAttempt = plantingAttemptRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attempt Not Found!"));
        return modelMapper.map(plantingAttempt, PlantingAttemptDTO.class);
    }

    @Override
    public void deleteOffer(Long offerId) {
        plantingAttemptRepository.deleteById(offerId);
    }

    @Override
    public List<PlantingAttemptDTO> getAllPlantingAttemptsForUser(String username) {
       return plantingAttemptRepository.getAllByUsernameOrderByPlantingDate(username).stream()
                .map(plantingAttempt -> modelMapper.map(plantingAttempt, PlantingAttemptDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlantingAttemptDTO> getAllPlantingAttemptsOfOthers (String username){
        return plantingAttemptRepository.getAllByUsernameNotOrderByPlantingDate(username).stream()
                .map(plantingAttempt -> modelMapper.map(plantingAttempt, PlantingAttemptDTO.class))
                .collect(Collectors.toList());
    }

    private final PlantingAttemptRepository plantingAttemptRepository;
    private final DateTimeFormatter dateTimeFormatter;
    private final ModelMapper modelMapper;

    public PlantingAttemptServiceImpl(PlantingAttemptRepository plantingAttemptRepository, DateTimeFormatter dateTimeFormatter, ModelMapper modelMapper) {
        this.plantingAttemptRepository = plantingAttemptRepository;
        this.dateTimeFormatter = dateTimeFormatter;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addPlantingAttempt(PlantingAttemptDTO addPlantingAttemptDTO) {
        PlantingAttempt mapped = modelMapper.map(addPlantingAttemptDTO, PlantingAttempt.class);
        mapped.setPlantingDate(LocalDate.parse(addPlantingAttemptDTO.getPlantingDate(),dateTimeFormatter));

        plantingAttemptRepository.save(mapped);
    }
}
