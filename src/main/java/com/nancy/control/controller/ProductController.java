package com.nancy.control.controller;

import com.nancy.control.bean.Production;
import com.nancy.control.bean.ResponseVO;
import com.nancy.control.service.ProductionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @RequiresPermissions("product[list]")//权限管理;
    public ResponseVO listProduction() {
        return productionService.getAllProduction();
    }

    @DeleteMapping("/products/{id}")
    @RequiresPermissions("product[delete]")
    public ResponseVO deleteProduction(@PathVariable String id) {
        return new ResponseVO("DELETE");
    }

    @GetMapping("/products/{id}")
    @RequiresPermissions("product[list]")
    public ResponseVO getProduction(@PathVariable String id) {
        return new ResponseVO("GET");
    }

    @PatchMapping("/products/{id}")
    @RequiresPermissions("product[edit]")
    public ResponseVO updateProduction(@PathVariable String id, @RequestBody Production production) {
        return new ResponseVO("patch");
    }

    @PostMapping("/products/create")
    @RequiresPermissions("product[upload]")
    public ResponseVO createProduction(@RequestBody Production production) {
        return null;
    }
}
