package com.example.demo.service;

import com.example.demo.domain.dianweiTtemple;

import java.util.List;

public interface DianweiTtempService {
    int insert(dianweiTtemple record);
    int insertSelective(dianweiTtemple record);
    List<dianweiTtemple> selectAll();
    int deleteByPrimaryKey(String id);
    int updateByPrimaryKeySelective(dianweiTtemple record);
    dianweiTtemple selectById(String id);
}
