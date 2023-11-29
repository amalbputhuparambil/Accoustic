package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.model.Product;
import com.brocamp.AcousticAlchemy.model.ProductDto;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(ProductDto productDto);

    void enableById(Long id);

    Product findById(Long id);

    List<Product> findAllProducteNotDeleted();


    List<Product> findAllByCategoryId(Long id);

    List<Product> findProductNameContainig(String name);

    List<Product> findCurrentProducts();

    boolean existsById(long id);
    Page<Product> findPaginated(int pageNo,int pageSize);

    long findOutOfStockProducts();

    long findTotalNotDeletedProducts();

    long findActiveProducts();

    long findInActiveProducts();

    void update(Product product);

    List<Object[]> getProductsStatsBetweenDates(Date fromDate, Date toDate);

    List<Object[]> getProductStats();
}
