package com.example.demo.service.impl;

import com.example.demo.domain.SocreTotal;
import com.example.demo.mapper.SocreTotalMapper;
import com.example.demo.service.SocreTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SocreTotalServiceImpl implements SocreTotalService {
    @Autowired
    private SocreTotalMapper socreTotalMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(SocreTotal record) {
        return this.socreTotalMapper.insert(record);
    }

    @Override
    public int insertSelective(SocreTotal record) {
        return 0;
    }

    @Override
    public List<SocreTotal> selectByCourseId(String userId, String courseId) {
        return this.socreTotalMapper.selectByCourseId(userId,courseId);
    }

    @Override
    public Float selectByAvg(String courseId) {
        return this.socreTotalMapper.selectByAvg(courseId);
    }

    @Override
    public SocreTotal selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SocreTotal record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SocreTotal record) {
        return 0;
    }
}
