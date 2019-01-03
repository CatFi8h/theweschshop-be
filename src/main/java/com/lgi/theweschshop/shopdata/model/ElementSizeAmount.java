package com.lgi.theweschshop.shopdata.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    public ElementSizeAmount(Integer amount, Element element, SizeEntity size) {
        this.amount = amount;
        this.element = element;
        this.size = size;
    }
}
