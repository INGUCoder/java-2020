package com.example.demo.service;

import com.example.demo.domain.Answer;

import java.util.List;
import java.util.Map;

public interface AnswerService {
    int insert(Answer record);

    int insertSelective(Answer record);

    List<Map<Object,Object>> selectByUserId(String userId);

    int updateByPrimaryKeySelective(Answer answer);

    Answer selectById(String id);

    List<Answer> selectByStatus();

    List<Answer> selectAll();
    List<Answer>  selectAllByzPaiming();
    List<Answer>  selectAllByzTuchu();
    List<Answer>  selectAllByShequ();
}
