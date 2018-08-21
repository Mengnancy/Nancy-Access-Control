package com.nancy.control.controller;

import com.nancy.control.bean.Production;
import com.nancy.control.bean.ResponseVO;
import com.nancy.control.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/19 16:16
 */
@RestController
public class ProductController {
    @Autowired
    ProductionService productionService;

    @GetMapping("/products")
    public ResponseVO listProduction() {
        return productionService.getAllProduction();
    }

    @DeleteMapping("/products/{id}")
    public ResponseVO deleteProduction(@PathVariable String id) {
        return new ResponseVO("DELETE");
    }

    @GetMapping("/products/{id}")
    public ResponseVO getProduction(@PathVariable String id) {
        return new ResponseVO("GET");
    }

    @PatchMapping("/products/{id}")
    public ResponseVO updateProduction(@PathVariable String id, @RequestBody Production production) {
        return new ResponseVO("patch");
    }

    @PostMapping("/products/create")
    public ResponseVO createProduction(@RequestBody Production production) {
        return null;
    }
}
