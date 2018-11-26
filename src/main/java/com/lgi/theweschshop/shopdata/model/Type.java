package com.lgi.theweschshop.shopdata.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "type_table")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}