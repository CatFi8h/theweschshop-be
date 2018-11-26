package com.lgi.theweschshop.shopdata.model;

import com.lgi.theweschshop.shopdata.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "tws_storage", name = "users")
public class EUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NonNull
    @Column(unique = true)
    private String email;

    private String password;

    private String name;

    private String surname;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public EUser(String email, String password, String name ) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public EUser(String email, String password, String name, String surname ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "EUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
