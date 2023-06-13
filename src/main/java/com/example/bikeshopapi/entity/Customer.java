package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import org.hibernate.envers.*;

@Entity
@Data
public class Customer extends TemporalBaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owner")
    @NotAudited
    private List<CustomerBike> customerBikes;

    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
    }

}
