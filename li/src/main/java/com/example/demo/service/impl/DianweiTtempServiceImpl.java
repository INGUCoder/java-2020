package com.example.demo.service.impl;

import com.example.demo.domain.dianweiTtemple;
import com.example.demo.mapper.dianweiTtempleMapper;
import com.example.demo.service.DianweiTtempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DianweiTtempServiceImpl implements DianweiTtempService {
    @Autowired
    private dianweiTtempleMapper dianweiTtempleMapper;

    @Override
    public int insert(dianweiTtemple record) {
        return 0;
    }

    @Override
    public int insertSelective(dianweiTtemple record) {
        return dianweiTtempleMapper.insertSelective(record);
    }

    @Override
    public List<dianweiTtemple> selectAll() {
        return this.dianweiTtempleMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return dianweiTtempleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(dianweiTtemple record) {
        return dianweiTtempleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public dianweiTtemple selectById(String id) {
        return dianweiTtempleMapper.selectById(id);
    }
}
