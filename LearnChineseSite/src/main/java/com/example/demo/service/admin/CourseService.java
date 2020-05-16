package com.example.demo.service.admin;

import com.example.demo.domain.Course;

import java.util.List;

public interface CourseService {
    int deleteByPrimaryKey(String id);

    int insert(Course record);

    List<Course> selectAll();

    int insertSelective(Course record);

    Course selectByPrimaryKey(String id);

    List<Course> selectBySearch(String name);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}
