package com.scaler.bookmyshowjan25.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel {
    private Movie movie;
    private Theatre theatre;
    private Screen screen;
    private Date startTime;
    private Date endTime;
    private List<Feature> features;
    private String language;
}
