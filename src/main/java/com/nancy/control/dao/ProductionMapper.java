package com.nancy.control.dao;

import com.github.pagehelper.Page;
import com.nancy.control.bean.Production;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductionMapper {

    List<Production> getAllProduction();

    Page<Production> getPageProduction();

    Production getProduction(String id);

    int deleteProduction(String id);

    int updateProduction(Production production);

    int createProduction(Production production);

    int updateDirectory(Production production);
}