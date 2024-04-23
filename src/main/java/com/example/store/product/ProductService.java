package com.example.store.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class ProductService {
    private final EntityManager em;

    @Transactional
    public void save(String name, Integer price, Integer qty){
        Query query =
                em.createNativeQuery("insert into product_tb(name, price, qty, createdAt) values(?,?,?, now())");
        query.setParameter(1, name);
        query.setParameter(2, price);
        query.setParameter(3, qty);
        query.executeUpdate();
    }
}
