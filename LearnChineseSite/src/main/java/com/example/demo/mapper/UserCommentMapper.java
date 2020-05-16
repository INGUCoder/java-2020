package com.example.demo.mapper;

import com.example.demo.domain.UserComment;

import java.util.List;

public interface UserCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserComment record);

    List<UserComment> selectAll();

    List<UserComment> selectAllByStatus();

    int insertSelective(UserComment record);

    UserComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserComment record);

    int updateByPrimaryKey(UserComment record);
}