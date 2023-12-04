package com.gck.reply.service;


import com.gck.factory.MyBatisFactory;
import com.gck.reply.model.ReplyDAO;
import com.gck.reply.model.ReplyVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class ReplyService implements ReplyDAO {

    SqlSession sqlSession;
    private ReplyDAO mapper;

    public ReplyService(){}



    //댓글 리스트 불러오기
    public List<ReplyVO> getRepliesByPost(int postIdx) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(ReplyDAO.class);

        List<ReplyVO> list = mapper.getRepliesByPost(postIdx);

        sqlSession.close();
        return list;
    }

    //댓글 작성
    public int createReplies(ReplyVO replyVO) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(ReplyDAO.class);
        int result = mapper.createReplies(replyVO);
            if (result == 1) {
                sqlSession.commit();
                System.out.println("replyservice_create");
            } else {
                System.out.println("replyservice_create_fail");
            }
            sqlSession.close();
            return result;
        }
}

    // 업데이트, 삭제 추가예정
