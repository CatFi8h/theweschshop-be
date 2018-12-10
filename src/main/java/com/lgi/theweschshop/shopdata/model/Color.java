package com.lgi.theweschshop.shopdata.model;


import javax.persistence.*;

@Entity(name = "color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
