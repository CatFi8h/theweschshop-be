package com.lgi.theweschshop.shopdata.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@Table(schema = "tws_storage", name = "element_table")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "gender")
    private String gender;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type")
    private Type type;

    @OneToMany(mappedBy = "element", cascade = CascadeType.ALL)
    private Set<ElementSizeAmount> elementSizeAmounts;

    @Column(name = "price", scale = 0, columnDefinition = "numeric")
    private Double price;

    @Column(name = "components")
    private String components;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
