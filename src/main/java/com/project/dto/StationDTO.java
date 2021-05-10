package com.project.dto;
import java.sql.Timestamp;

public class StationDTO {
    private int id;
    private String stationName;
//    @Column(name = "train_number")
//    private int train_number;

    private Timestamp time;
    private TrainDTO trainDTO;

    public StationDTO() {
    }

    public StationDTO(String stationName) {
        this.stationName = stationName;
    }

    public int getId() {
        return id;
    }

    //TODO deal with exceptions
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public TrainDTO getTrainDTO() {
        return trainDTO;
    }

    public void setTrainDTO(TrainDTO trainDTO) {
        this.trainDTO = trainDTO;
    }
}
