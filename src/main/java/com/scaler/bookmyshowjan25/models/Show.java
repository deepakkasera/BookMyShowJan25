package com.scaler.bookmyshowjan25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name = "shows")
@Getter
@Setter
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theatre theatre;

    @OneToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    @ManyToOne
    private Language language;
}


/*

  1          1
Show ----- Screen => 1:1
  1          1

 */