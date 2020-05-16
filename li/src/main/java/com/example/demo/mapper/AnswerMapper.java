package com.example.demo.mapper;

import com.example.demo.domain.Answer;

import java.util.List;
import java.util.Map;

public interface AnswerMapper {
    int insert(Answer record);

    List<Answer> selectByStatus();

    int updateByPrimaryKeySelective(Answer answer);

    Answer selectById(String id);

    int insertSelective(Answer record);

    List<Map<Object,Object>> selectByUserId(String userId);
    List<Answer> selectAll();

    List<Answer>  selectAllByzPaiming();

    List<Answer>  selectAllByzTuchu();

    List<Answer>  selectAllByShequ();




}