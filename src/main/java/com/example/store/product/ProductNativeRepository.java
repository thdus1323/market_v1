package com.example.store.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductNativeRepository {
    private final EntityManager em;

    public List<Product>findAll(){
        Query query = em.createNativeQuery("select * from product_tb order by id desc",Product.class);
        return query.getResultList();
    }
}
