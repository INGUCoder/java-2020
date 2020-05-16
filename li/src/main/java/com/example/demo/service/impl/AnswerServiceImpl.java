package com.example.demo.service.impl;

import com.example.demo.domain.Answer;
import com.example.demo.mapper.AnswerMapper;
import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    @Override
    public int insert(Answer record) {
        return this.answerMapper.insert(record);
    }

    @Override
    public int insertSelective(Answer record) {
        return 0;
    }

    @Override
    public List<Map<Object,Object>> selectByUserId(String userId) {
        return answerMapper.selectByUserId(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(Answer answer) {
        return answerMapper.updateByPrimaryKeySelective(answer);
    }

    @Override
    public Answer selectById(String id) {
        return answerMapper.selectById(id);
    }

    @Override
    public List<Answer> selectByStatus() {
        return answerMapper.selectByStatus();
    }

    @Override
    public List<Answer> selectAll() {
        return answerMapper.selectAll();
    }

    @Override
    public List<Answer> selectAllByzPaiming() {
        return answerMapper.selectAllByzPaiming();
    }

    @Override
    public List<Answer> selectAllByzTuchu() {
        return answerMapper.selectAllByzTuchu();
    }

    @Override
    public List<Answer> selectAllByShequ() {
        return answerMapper.selectAllByShequ();
    }
}
