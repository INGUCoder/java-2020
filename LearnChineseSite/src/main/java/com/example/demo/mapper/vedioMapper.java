package com.example.demo.mapper;

import com.example.demo.domain.vedio;

import java.util.List;

public interface vedioMapper {
    int deleteByPrimaryKey(String id);

    int insert(vedio record);

    int insertSelective(vedio record);

    vedio selectByPrimaryKey(String id);

    List<vedio> selectByCourseId(String courseId);

    List<vedio> selectByAll();

    int updateByPrimaryKeySelective(vedio record);

    int updateByPrimaryKey(vedio record);
}