package com.ss.training.utopia.entity;

import javax.persistence.*;

@Entity
@Table(name = "airplane_type")
public class AirplaneType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "max_capacity")
    private Integer maxCapacity;

    // GET
    public Integer getId() {
        return id;
    }
    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    // SET
    public void setId(Integer id) {
        this.id = id;
    }
    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

}
