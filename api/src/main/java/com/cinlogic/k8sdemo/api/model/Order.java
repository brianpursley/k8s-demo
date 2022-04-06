package com.cinlogic.k8sdemo.api.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private Instant createdOn;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "order")
    private List<OrderLine> lines;

    public int getId() {
        return id;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }
}
