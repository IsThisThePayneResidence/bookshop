package com.bookshop.domain;

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
    private Double buyPrice;

    @Column
    private Double sellPrice;

    public Product() {

    }

    public Product(String type, String name, String brand, String author, long number, double buyPrice, double sellPrice) {
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.author = author;
        this.number = number;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

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

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

}
