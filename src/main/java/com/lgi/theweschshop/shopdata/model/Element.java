package com.lgi.theweschshop.shopdata.model;

import com.lgi.theweschshop.shopdata.response.AdminElementResponse;
import com.lgi.theweschshop.shopdata.response.IdNameDto;
import com.lgi.theweschshop.shopdata.response.SizeAmountResponseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "color")
    private Color color;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

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

    public AdminElementResponse toAdminElementResponse() {
        AdminElementResponse response = new AdminElementResponse();
        Set<ElementSizeAmount> elementSizeAmounts = this.getElementSizeAmounts();
        List<SizeAmountResponseDto> collect = elementSizeAmounts.stream().map(e -> new SizeAmountResponseDto(
                new IdNameDto(e.getSize().getId(), e.getSize().getName()), e.getAmount()))
                .collect(Collectors.toList());

        response.setSizeAmount(collect);
        response.setId(this.getId());
//        Color color = this.getColor();
        Type type = this.getType();

//        response.setColor(new IdNameDto(color.getId(), color.getName()));
        response.setName(this.getName());
        response.setType(new IdNameDto(type.getId(), type.getName()));
        response.setGender(this.getGender());

        return response;
    }
}
