package net.springboot.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.springboot.homework.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
