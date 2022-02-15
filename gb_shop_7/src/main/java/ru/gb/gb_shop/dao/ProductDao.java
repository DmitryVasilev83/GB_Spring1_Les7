package ru.gb.gb_shop.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gb_shop.entity.Product;




public interface ProductDao extends JpaRepository<Product, Long> {


}
