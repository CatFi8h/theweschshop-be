package com.lgi.theweschshop.shopdata.response;

import com.lgi.theweschshop.shopdata.model.Color;
import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.Type;
import lombok.Value;

import java.util.List;

@Value
public class ElementDto {
    private Long id;

    private String name;

    private IdNameDto type;

    private IdNameDto color;

    private String gender;

    public static ElementDto toElementDto(Element element) {
        Type type = element.getType();
        Color color = element.getColor();
        Long colorId=null;
        String colorName=null;
        if (color != null) {
            colorId = color.getId();
            colorName = color.getName();
        }
        return new ElementDto(element.getId(), element.getName(),
                new IdNameDto(type.getId(), type.getName()),
                new IdNameDto(colorId, colorName),
                element.getGender());
    }
}
