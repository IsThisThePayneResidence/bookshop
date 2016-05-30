package com.bookshop.services.products.impl;

import com.bookshop.domain.Product;
import com.bookshop.repository.ProductRepository;
import com.bookshop.services.products.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by
 *
 * @author ivan
 *         On 5/30/16
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }
}
