package com.ss.training.utopia.entity;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iata_id")
    private String id;

    @Column(name = "city")
    private String city;

    // GET
    public String getId() { return id; }
    public String getCity() { return city; }

    // SET
    public void setId(String id) { this.id = id; }
    public void setCity(String city) { this.city = city; }
}
