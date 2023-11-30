package com.gck.reply.service;


import com.gck.factory.MyBatisFactory;
import com.gck.reply.model.ReplyDAO;
import com.gck.reply.model.ReplyVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class ReplyService  {

    SqlSession sqlSession;
    private ReplyDAO mapper;

    public ReplyService(){}

    public List<ReplyVO> getRepliesByPost(int postIdx) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(ReplyDAO.class);

        List<ReplyVO> list = mapper.getRepliesByPost(postIdx);

        sqlSession.close();
        return list;
    }
    // 작성, 업데이트, 삭제 추가예정
}
