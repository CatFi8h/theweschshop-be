package com.lgi.theweschshop.shopdata.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "tws_storage", name = "size_table")
public class SizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    public SizeEntity(String name) {
        this.name = name;
    }
}
