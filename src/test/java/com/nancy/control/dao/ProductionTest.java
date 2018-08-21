package com.nancy.control.dao;

import com.nancy.control.bean.Production;
import com.nancy.control.service.ProductionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/21 22:30
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductionTest {
    @Autowired
    ProductionMapper productionMapper;

    @Test
    public void getAllProductionTest() {
        List<Production> productionList = productionMapper.getAllProduction();
        productionList.stream().map(production -> production.getProductName()).forEach(System.out::println);
    }

    @Test
    public void getProductionTest() {
        Production production = productionMapper.getProduction("5714f0f2a37611e8949cb06ebf8005a8");
        System.out.println(production.getProductName());
    }

    @Test
    public void insertProdutionTest(){
        Production production = new Production();
        production.setProductAuthor("灵心");
        production.setProductName("插入新数据");
//        production.setProductDesc("一会就删除了");

        productionMapper.createProduction(production);
    }

    @Test
    public void updateProductionTest(){
        Production production = new Production();
        production.setIdProduction("493d0b17a55611e8a9cab06ebf8005a8");
        production.setProductName("修改测试");

        productionMapper.updateProduction(production);
    }
}
