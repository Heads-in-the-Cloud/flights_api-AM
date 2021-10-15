package com.ss.training.utopia.entity;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class Airplane {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="type_id")
    private AirplaneType airplaneType;

    // GET
    public Integer getId() { return id; }
    public AirplaneType getAirplaneType() { return airplaneType; }

    // SET
    public void setId(Integer id) { this.id = id; }
    public void setAirplaneType(AirplaneType airplaneType) { this.airplaneType = airplaneType; }

}
