package com.lgi.theweschshop.shopdata.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Getter
@Setter
@Table(schema = "tws_storage",name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "element_id")
    private Long elementId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Element element;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd", Locale.getDefault() );
        return dateFormat.format( creationDate );
    }

    public String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "HH:mm", Locale.getDefault() );
        return simpleDateFormat.format( creationDate );
    }
}
