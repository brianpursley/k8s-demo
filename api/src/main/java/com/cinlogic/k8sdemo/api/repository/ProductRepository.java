package com.cinlogic.k8sdemo.api.repository;

import com.cinlogic.k8sdemo.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
