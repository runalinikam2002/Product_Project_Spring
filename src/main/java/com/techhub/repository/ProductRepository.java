package com.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.techhub.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
