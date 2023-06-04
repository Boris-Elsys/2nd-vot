package com.example.bikeshopapi.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Bike {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;
    private String model;
    private String color;
    private String size;
    private String type;
    private String frame;
    private String fork;
    private String shock;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setFrame(String frame){
        this.frame = frame;
    }

    public String getFrame(){
        return frame;
    }

    public void setFork(String fork){
        this.fork = fork;
    }

    public String getFork(){
        return fork;
    }

    public void setShock(String shock){
        this.shock = shock;
    }

    public String getShock(){
        return shock;
    }

}
