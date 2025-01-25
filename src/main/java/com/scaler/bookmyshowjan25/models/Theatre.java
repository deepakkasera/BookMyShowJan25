package com.scaler.bookmyshowjan25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel {
    private String name;
    private String address;

    @OneToMany
    private List<Screen> screens;

    @ManyToOne
    private City city;
}
