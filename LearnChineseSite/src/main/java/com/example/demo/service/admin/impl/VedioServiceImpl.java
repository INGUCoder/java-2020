package com.example.demo.service.admin.impl;

import com.example.demo.domain.vedio;
import com.example.demo.mapper.vedioMapper;
import com.example.demo.service.admin.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VedioServiceImpl implements VedioService {
    @Autowired
    private vedioMapper vedioMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return this.vedioMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(vedio record) {
        return this.vedioMapper.insert(record);
    }

    @Override
    public int insertSelective(vedio record) {
        return this.vedioMapper.insertSelective(record);
    }

    @Override
    public vedio selectByPrimaryKey(String id) {
        return this.vedioMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<vedio> selectByCourseId(String courseId) {
        return this.vedioMapper.selectByCourseId(courseId);
    }

    @Override
    public List<vedio> selectByAll() {
        return this.vedioMapper.selectByAll();
    }

    @Override
    public int updateByPrimaryKeySelective(vedio record) {
        return this.vedioMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(vedio record) {
        return this.vedioMapper.updateByPrimaryKey(record);
    }
}
