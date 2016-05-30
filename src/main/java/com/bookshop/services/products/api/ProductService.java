package com.bookshop.services.products.api;

import com.bookshop.domain.Product;

import java.util.List;

/**
 * Created by
 *
 * @author ivan
 *         On 5/30/16
 */
public interface ProductService {

    List<Product> findAll();

    Product save(Product product);

}
