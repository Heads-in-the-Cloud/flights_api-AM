package com.ss.training.utopia.entity;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="destination_id")
    private Airport destination;

    @ManyToOne
    @JoinColumn(name="origin_id")
    private Airport origin;

    // GET
    public Integer getId() { return id; }
    public Airport getOrigin() { return origin; }
    public Airport getDestination() { return destination; }

    // SET
    public void setId(Integer id) { this.id = id; }
    public void setOrigin(Airport origin) { this.origin = origin; }
    public void setDestination(Airport destination) { this.destination = destination; }
}
