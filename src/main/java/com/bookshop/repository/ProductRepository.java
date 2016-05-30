package com.bookshop.repository;

import com.bookshop.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by
 *
 * @author ivan
 * On 4/28/16
 */

@Transactional(propagation = Propagation.MANDATORY)
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findByType(String type);

    List<Product> findByType(String type, Pageable pageable);

    List<Product> findByType(String type, Sort sort);

    List<Product> findByName(String name);

    Page<Product> findByName(String name, Pageable pageable);

    List<Product> findByName(String name, Sort sort);

    List<Product> findByBrand(String brand);

    Page<Product> findByBrand(String brand, Pageable pageable);

    List<Product> findByBrand(String brand, Sort sort);

    List<Product> findByAuthor(String author);

    Page<Product> findByAuthor(String author, Pageable pageable);

    List<Product> findByAuthor(String author, Sort sort);

    List<Product> findByNumber(Long number);

    List<Product> findByPrice(Float price);

}
