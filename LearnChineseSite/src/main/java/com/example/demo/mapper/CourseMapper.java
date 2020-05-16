package com.example.demo.mapper;

import com.example.demo.domain.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String id);

    List<Course> selectAll();

    List<Course> selectBySearch(String name);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}