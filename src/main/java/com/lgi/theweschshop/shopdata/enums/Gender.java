package com.lgi.theweschshop.shopdata.enums;

public enum Gender {

    male,
    female;

    public static Gender valueOfIgnoreCase(String value) {
        for (Gender gender : values()) {
            if (gender.name().equalsIgnoreCase(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException();
    }
}
