package com.bookshop.service.accounting.api;

import com.bookshop.domain.Product;

import java.util.List;


public interface AccountingService {

    Product addProduct(Product product);

    List<Product> getProducts();
}
