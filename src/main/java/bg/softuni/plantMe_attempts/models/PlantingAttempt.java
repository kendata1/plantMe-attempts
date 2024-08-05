package bg.softuni.plantMe_attempts.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "planting_attempts")
public class PlantingAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String plant;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String variety;
    @Column(name = "planting_date", nullable = false)
    private LocalDate plantingDate;
    @Column(name = "seed-info")
    private String seedInfo;
    @Column(name = "seedling_info")
    private String seedlingInfo;
    @Column(name = "main_info", columnDefinition = "TEXT", nullable = false)
    private String mainInfo;

    public PlantingAttempt() {
    }

    public String getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo;
    }

    public long getId() {
        return id;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public LocalDate getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(LocalDate plantingDate) {
        this.plantingDate = plantingDate;
    }

    public String getSeedInfo() {
        return seedInfo;
    }

    public void setSeedInfo(String seedInfo) {
        this.seedInfo = seedInfo;
    }

    public String getSeedlingInfo() {
        return seedlingInfo;
    }

    public void setSeedlingInfo(String seedlingInfo) {
        this.seedlingInfo = seedlingInfo;
    }
}


