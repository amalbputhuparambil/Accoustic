package com.brocamp.AcousticAlchemy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private Long id;

    private String name;

    private String description;

    private int offPercentage;

    private String offerType;

    @Column(nullable = true)
    private Long offerProductId;
    @Column(nullable = true)
    private String applicableForProductName;
    @Column(nullable = true)
    private Long offerCategoryId;
    @Column(nullable = true)
    private String applicableForCategoryName;

    private boolean enabled;
    private boolean deleted;
    private Date createdAt;
    private Date updateOn;

}
