package com.nancy.control.controller;

import com.github.pagehelper.PageHelper;
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

    @GetMapping("/pageProducts")
    @RequiresPermissions("product[list]")//权限管理;
    public ResponseVO listProdutionPage(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "2") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return productionService.getPageProduction();
    }

    @DeleteMapping("/products/{id}")
    @RequiresPermissions("product[delete]")
    public ResponseVO deleteProduction(@PathVariable String id) {
        return productionService.deleteProduction(id);
    }

    @GetMapping("/products/{id}")
    @RequiresPermissions("product[list]")
    public ResponseVO getProduction(@PathVariable String id) {
        return productionService.getProduction(id);
    }

    @PatchMapping("/products")
    @RequiresPermissions("product[edit]")
    public ResponseVO updateProduction(@RequestBody Production production) {
        System.out.println("product[edit]");
        return productionService.updateProduction(production);
    }

    @PostMapping("/products/create")
    @RequiresPermissions("product[upload]")
    public ResponseVO createProduction(@RequestBody Production production) {
        return productionService.createProduction(production);
    }
}
