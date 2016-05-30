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
public class InvoiceProduct extends Product {

    @ManyToOne
    private Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
