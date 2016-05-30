package com.bookshop.services.accounting.impl;

import com.bookshop.domain.Product;
import com.bookshop.repository.ProductRepository;
import com.bookshop.services.accounting.api.AccountingService;
import com.bookshop.services.products.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service(value = "accountingService")
@Transactional
public class AccountingServiceImpl implements AccountingService {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void postConstruct() {
        addProduct(new Product("Book", "Harry Potter", "Aladdin Print", "J.K. Rowling", 12, 55.12, 105.55));
        addProduct(new Product("Magazine", "Wall Street Journal", "Wall Print", "N/A", 44, 43.86, 90.00));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
