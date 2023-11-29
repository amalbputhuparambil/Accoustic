package com.brocamp.AcousticAlchemy.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
public class OfferDTO {
    private Long id;
    @NotNull
    @Pattern(regexp = "\\S+", message = "Field must contain non-whitespace characters")
    private String name;
    @NotNull
    private String description;
    @Min(value = 1)
    @Max(value = 100)
    private int offPercentage;

    private String offerType;

    private Long offerProductId;
    private String applicableForProductName;
    private Long offerCategoryId;
    private String applicableForCategoryName;

    private boolean enabled;
    private boolean deleted;
    private Date createdAt;
    private Date updateOn;
}
