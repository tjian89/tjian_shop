package com.tjian.service.impl;

import com.tjian.dao.ProductDao;
import com.tjian.entity.ProductPo;
import com.tjian.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public Long addProduct(ProductPo product) {
        productDao.addProduct(product);
        return product.getProductId();
    }

    @Override
    public ProductPo getProduct(Long id){
        return productDao.getProduct(id);
    }

    @Override
    public int updateProduct(ProductPo product) {
        return productDao.updateProduct(product);
    }

    @Override
    public int deleteProduct(Long id) {
        return productDao.deleteProduct(id);
    }
}
