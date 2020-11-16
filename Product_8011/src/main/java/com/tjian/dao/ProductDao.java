package com.tjian.dao;

import com.tjian.entity.ProductPo;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

    int addProduct(ProductPo product);

    ProductPo getProduct(Long id);

    int updateProduct(ProductPo product);

    int deleteProduct(Long id);
}
