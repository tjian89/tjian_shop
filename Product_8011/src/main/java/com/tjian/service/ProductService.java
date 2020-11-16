package com.tjian.service;

import com.tjian.entity.ProductPo;

public interface ProductService {

    Long addProduct(ProductPo product);

    ProductPo getProduct(Long id);

    int updateProduct(ProductPo product);

    int deleteProduct(Long id);
}
