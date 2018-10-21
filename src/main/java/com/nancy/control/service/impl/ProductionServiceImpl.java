package com.nancy.control.service.impl;

import com.github.pagehelper.PageInfo;
import com.nancy.control.bean.Production;
import com.nancy.control.bean.ResponseVO;
import com.nancy.control.dao.ProductionMapper;
import com.nancy.control.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/19 20:25
 */
@Service
public class ProductionServiceImpl implements ProductionService {
    @Autowired
    private ProductionMapper productionMapper;

    @Override
    public ResponseVO getAllProduction() {
        List<Production> all = productionMapper.getAllProduction();
        return new ResponseVO(all);
    }

    @Override
    public ResponseVO getPageProduction() {
        PageInfo<Production> pageInfo = new PageInfo<>(productionMapper.getPageProdution());
        return new ResponseVO(pageInfo);
    }

    @Override
    public ResponseVO getProduction(String id) {
        Production production = productionMapper.getProduction(id);
        return new ResponseVO(production);
    }

    @Override
    public ResponseVO deleteProduction(String id) {
        int result = productionMapper.deleteProduction(id);
        return new ResponseVO(result);

    }

    @Override
    public ResponseVO updateProduction(Production production) {
        int result = productionMapper.updateProduction(production);
        return new ResponseVO(result);
    }

    @Override
    public ResponseVO createProduction(Production production) {
        int result = productionMapper.createProduction(production);
        return new ResponseVO(result);
    }
}
