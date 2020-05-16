package com.example.demo.service.admin.impl;

import com.example.demo.domain.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.admin.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return this.courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Course record) {
        return this.courseMapper.insert(record);
    }

    @Override
    public List<Course> selectAll() {
        return this.courseMapper.selectAll();
    }

    @Override
    public int insertSelective(Course record) {
        return this.courseMapper.insertSelective(record);
    }

    @Override
    public Course selectByPrimaryKey(String id) {
        return this.courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Course> selectBySearch(String name) {
        return this.courseMapper.selectBySearch(name);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return this.courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Course record) {
        return this.courseMapper.updateByPrimaryKey(record);
    }
}
