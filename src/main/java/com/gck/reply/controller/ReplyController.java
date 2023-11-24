package com.gck.reply.controller;

import com.gck.config.MyBatisConfig;
import com.gck.reply.model.ReplyVO;
import com.gck.reply.model.ReplyDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ReplyController {
    public List<ReplyVO> getReplies(Map<String, Object> map) {

        SqlSession sqlSession = (SqlSession) MyBatisConfig.getSqlSessionFactory();
        ReplyDAO replyDAO = sqlSession.getMapper(ReplyDAO.class);

        List<ReplyVO> result = replyDAO.getReplies(map);
        sqlSession.close();
        return result;
    }
}
