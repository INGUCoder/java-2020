package com.example.demo.mapper;

import com.example.demo.domain.SocreTotal;

import java.util.List;

public interface SocreTotalMapper {
    int deleteByPrimaryKey(String id);

    int insert(SocreTotal record);

    int insertSelective(SocreTotal record);

    List<SocreTotal> selectByCourseId(String userId, String courseId);

    Float selectByAvg(String courseId);

    SocreTotal selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SocreTotal record);

    int updateByPrimaryKey(SocreTotal record);
}