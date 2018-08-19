package com.nancy.control.service.impl;

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
    public ResponseVO getProduction(String id) {
        return null;
    }

    @Override
    public ResponseVO deleteProduction(String id) {
        return null;
    }

    @Override
    public ResponseVO updateProduction(String id) {
        return null;
    }

    @Override
    public ResponseVO createProduction(String id) {
        return null;
    }
}
