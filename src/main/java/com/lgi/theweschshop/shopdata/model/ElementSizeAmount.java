package com.lgi.theweschshop.shopdata.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "element_size_amount")
public class ElementSizeAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "element_id", nullable = false)
    private Element element;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "size_id", nullable = false)
    private SizeEntity size;

}
