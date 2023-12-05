package com.gck.board.service;

import com.gck.board.model.BoardDAO;
import com.gck.board.model.BoardMemberVO;
import com.gck.board.model.BoardVO;
import com.gck.post.model.PostDAO;
import com.gck.post.model.PostMemberVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.session.SqlSession;

import com.gck.factory.MyBatisFactory;


import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor

public class BoardService {
    // DAO
    SqlSession sqlSession;
    BoardDAO mapper;

    // 생성자
    public BoardService(){

    }
//     서비스 메서드 시작, 종료할 때 반드시 넣어 주세요!
//     시작 시,
//     this.sqlSession = MyBatisFactory.getSqlSession(); mapper = this.sqlSession.getMapper(BoardDAO.class);
//     종료 시,
//     sqlSession.close();


    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
    public List<BoardVO> selectListPage(Map <String,Object> map) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);

        List<BoardVO> list = mapper.selectListPage(map);
        System.out.println("test : " + list);
        sqlSession.close();
        return list;
    }

    public int selectCount (Map <String,Object> map) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);
        int result = mapper.selectCount(map);
        sqlSession.close();
        return result;
    }


    public List<BoardMemberVO> selectNickView(Map<String,Object>map) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        BoardDAO mapper = this.sqlSession.getMapper(BoardDAO.class);
        List<BoardMemberVO> result = mapper.selectNickView(map);

        if (result != null) {
            System.out.println("조회된 게시물 : " + result);
        } else {
            System.out.println("게시물이 조회되지 않았습니다. postIdx: " + map);
        }

        sqlSession.close();
        return result;
    }

}
