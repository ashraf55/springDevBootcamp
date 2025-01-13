package com.udemy.springDevBootcamp;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Item {
    @NotBlank(message = "Please choose a category")
    private String category;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;
    @Min(value = 0, message = "Discount cannot be negative")
    private Double discount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "Date must be of the past")
    private Date date;
    private String id;

    public Item() {
        this.id = UUID.randomUUID().toString();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormatDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

}
