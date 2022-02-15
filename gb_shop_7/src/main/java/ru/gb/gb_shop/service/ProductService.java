package ru.gb.gb_shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import ru.gb.gb_shop.dao.HibernateProductDao;
import ru.gb.gb_shop.dao.CartDao;
import ru.gb.gb_shop.dao.ManufacturerDao;
import ru.gb.gb_shop.dao.ProductDao;
import ru.gb.gb_shop.entity.Product;
import ru.gb.gb_shop.entity.enums.Status;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;
    private final ManufacturerDao manufacturerDao;
    private final CartDao cartDao;

    public List<Product> findAll(){
        return productDao.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long id){
        return productDao.findById(id).get();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public Product save(Product product) {
        if (product.getId() != null) {
            Optional<Product> productFromDbOptional = productDao.findById(product.getId());
            if (productFromDbOptional.isPresent()) {
                Product productFromDb = productFromDbOptional.get();
                productFromDb.setTitle(product.getTitle());
                productFromDb.setDate(product.getDate());
                productFromDb.setCost(product.getCost());
                productFromDb.setStatus(product.getStatus());
                productFromDb.setManufacturer(product.getManufacturer());
                return productDao.save(productFromDb);
            }
        }
        return productDao.save(product);
    }

    public List<Product> findSortedByCost(Sort.Direction direction){
        return productDao.findAll(Sort.by(direction, "cost"));
    }






}
