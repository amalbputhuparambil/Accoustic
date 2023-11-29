package com.brocamp.AcousticAlchemy.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Data
public class CouponDTO {
    private long id;

    @NotNull(message = "is required")
    @Size(min=5, max=30,message = "Please enter coupon code")
    @Pattern(regexp = "\\S+", message = "Field must contain non-whitespace characters")
    private String couponCode;


    @NotNull(message = "is required")
    @Size(min=5, max=30,message = "Please enter coupon code")
    @Pattern(regexp = "\\S+", message = "Field must contain non-whitespace characters")
    private String description;


    @NotNull(message = "is required")
@Min(value = 1,message = "place enter the value between 1 and 100")
    @Max(value = 1,message = "place enter the value between 1 and 100")

    private double discount;
    //per user apply coupon count

    @NotNull(message = "is required")

    private long count;


    @NotNull(message = "is required")

    private double maximumAmount;


    @NotNull(message = "is required")
    private double minimumOrderAmount;
    private Date createdAt;
    private Date updateOn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;
    private boolean activated;
    private boolean deleted;
}
