package bg.softuni.plantMe_attempts.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "planting_attempts")
public class PlantingAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String plant;
    private String username;
    @Column(nullable = false)
    private String variety;
    @Column(name = "planting_date", nullable = false)
    private LocalDate plantingDate;
    private String seedInfo;
    private String seedlingInfo;

    public PlantingAttempt() {
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


