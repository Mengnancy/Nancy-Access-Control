package com.nancy.control.service;

import com.nancy.control.bean.Production;
import com.nancy.control.bean.ResponseVO;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/19 20:25
 */
public interface ProductionService {

    ResponseVO getAllProduction();

    ResponseVO getProduction(String id);

    ResponseVO deleteProduction(String id);

    ResponseVO updateProduction(Production production);

    ResponseVO createProduction(Production production);
}
