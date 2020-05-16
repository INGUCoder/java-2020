package com.example.demo.service.admin.impl;

import com.example.demo.domain.UserComment;
import com.example.demo.mapper.UserCommentMapper;
import com.example.demo.service.admin.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentServiceImpl implements UserCommentService {

    @Autowired
    private UserCommentMapper userCommentMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return this.userCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserComment record) {
        return this.userCommentMapper.insert(record);
    }

    @Override
    public int insertSelective(UserComment record) {
        return 0;
    }

    @Override
    public UserComment selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public List<UserComment> selectAllByStatus() {
        return this.userCommentMapper.selectAllByStatus();
    }

    @Override
    public int updateByPrimaryKeySelective(UserComment record) {
        return this.userCommentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserComment record) {
        return 0;
    }

    @Override
    public List<UserComment> selectAll() {
        return this.userCommentMapper.selectAll();
    }
}
