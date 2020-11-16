package com.tjian.controller;

import com.tjian.common.ResponseResult;
import com.tjian.entity.ProductPo;
import com.tjian.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping(value = "/add/product")
    public ResponseResult<Long> addProduct(@RequestBody ProductPo product){
        Long result = productService.addProduct(product);
        return ResponseResult.successWithResult(result);
    }

    @GetMapping("/get/product/{id}")
    public ResponseResult<ProductPo> getProduct(@PathVariable("id") Long id){
        ProductPo product = productService.getProduct(id);
        return ResponseResult.successWithResult(product);
    }

    @PostMapping("/update/product")
    public ResponseResult<Integer> updateProduct(@RequestBody ProductPo product){
        int result = productService.updateProduct(product);
        return ResponseResult.successWithResult(result);
    }

    @PostMapping("/delete/product/{id}")
    public ResponseResult<Integer> deleteProduct(@PathVariable("id") Long id){
        int result = productService.deleteProduct(id);
        return ResponseResult.successWithResult(result);
    }
}
