package com.bookshop.springfx.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by
 * @author ivan
 * On 4/28/16
 */

@Entity
@Table
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String type;

    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String author;

    @Column
    private Long number;

    @Column
    private Float buyPrice;

    @Column
    private Float sellPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }
}
