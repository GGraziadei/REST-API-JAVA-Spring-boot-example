package it.goodgamegroup.product.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.goodgamegroup.product.rest.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
