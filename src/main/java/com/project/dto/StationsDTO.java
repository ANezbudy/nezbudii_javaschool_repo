package com.project.dto;
import com.project.entity.Train;
import java.sql.Timestamp;

public class StationsDTO {
    private String id;
    private String station_name;
//    @Column(name = "train_number")
//    private int train_number;

    private Timestamp time;
    private TrainDTO trainDTO;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
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
