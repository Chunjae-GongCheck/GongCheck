package com.gck.board.service;

import com.gck.board.model.BoardVO;
import com.gck.post.model.PostDAO;
import org.apache.ibatis.session.SqlSession;

import com.gck.factory.MyBatisFactory;

import java.util.List;
import java.util.Map;

public class BoardServiceSample {
    // DAO
    SqlSession sqlSession;
    PostDAO mapper;

    // 생성자
    public BoardServiceSample(){}

    //
    // 서비스 메서드 시작, 종료할 때 반드시 넣어 주세요!
    // 시작 시,
    // this.sqlSession = MyBatisFactory.getSqlSession(); mapper = this.sqlSession.getMapper(BoardDAO.class);
    // 종료 시,
    // sqlSession.close();
    //

    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
    public List<BoardVO> selectListPage(){
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(PostDAO.class);

        List<BoardVO> list = mapper.selectListPage();

        sqlSession.close();
        return list;
    }
}
