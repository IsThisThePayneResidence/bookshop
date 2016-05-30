package com.bookshop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by
 * @author ivan
 * On 4/28/16
 */

@Entity
@Table
public class Invoice implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date date;

    @Column
    @Enumerated(EnumType.STRING)
    private InvoiceType type;

    @Column
    private String provider;

    @Column
    private String customer;

    @Column
    @OneToMany(mappedBy="invoice")
    private List<InvoiceProduct> products;

    @Column
    private Double sum;

    @Column
    private Short discount;
}
