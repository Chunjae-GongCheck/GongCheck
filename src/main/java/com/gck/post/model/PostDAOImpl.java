package com.gck.post.model;

import com.gck.factory.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class PostDAOImpl implements PostDAO {


//    public List<PostVO> selectListPage(Map<String, Object> map) {
//        SqlSession sqlSession = MyBatisFactory.getSqlSession();
//        PostDAO mapper = sqlSession.getMapper(PostDAO.class);
//        List<PostVO> result = mapper.selectListPage(map);
//        sqlSession.close();
//        return result;
//    }

//    public int selectCount(Map<String, Object> map) {
//        SqlSession sqlSession = MyBatisFactory.getSqlSession();
//        PostDAO mapper = sqlSession.getMapper(PostDAO.class);
//        int result = mapper.selectCount(map);
//        System.out.println("selectCount - 행 개수 = " + result);
//        sqlSession.close();
//        return result;
//    }

    public int insertPost(PostVO vo) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostDAO mapper = sqlSession.getMapper(PostDAO.class);
        int result = mapper.insertPost(vo);
        if (result == 1) {
            sqlSession.commit();
            System.out.println("새로운 게시글 저장 성공");
        } else {
            System.out.println("새로운 게시글 저장 실패");
        }
        sqlSession.close();
        return result;
    }

    public PostVO selectView(String postIdx) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostDAO mapper = sqlSession.getMapper(PostDAO.class);
        PostVO vo = mapper.selectView(postIdx);
        if (vo != null) {
            System.out.println("팝업 실행");
        } else {
            System.out.println("팝업 실패");
        }
        sqlSession.close();
        return vo;
    }

    public int updateVisitCount(String postIdx) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostDAO mapper = sqlSession.getMapper(PostDAO.class);
        int result = mapper.updateVisitCount(postIdx);
        System.out.println("update query result val = " + result);
        if (result == 1) {
            sqlSession.commit();
        } else {
            System.out.println("조회수 증가 중 오류 발생");
        }
        System.out.println("조회수 : " + result);
        sqlSession.close();
        return result;
    }

    public int deletePost(int postIdx) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostDAO mapper = sqlSession.getMapper(PostDAO.class);
        int result = mapper.deletePost(postIdx);
        if (result == 1) {
            sqlSession.commit();
        } else {
            System.out.println("게시판 글 삭제 중 오류 발생...");
        }

        return result;
    }

    public int updatePost(PostVO vo) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostDAO mapper = sqlSession.getMapper(PostDAO.class);
        int result = mapper.updatePost(vo);
        if (result == 1) {
            sqlSession.commit();
        } else {
            System.out.println("게시판 글 update 중 오류 발생...");
        }
        sqlSession.commit();
        return result;
    }

    public int insertPostImage(PostVO vo) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostDAO mapper = sqlSession.getMapper(PostDAO.class);
        int result = mapper.insertPostImage(vo);
        if (result == 1) {
            System.out.println("PostImage가 성공적으로 저장되었습니다.");
            sqlSession.commit();
        } else {
            System.out.println("PostImage 저장 실패.");
        }
        sqlSession.close();
        return result;
    }

    public List<PostVO> selectPostWithImage(Map<String, Object> map){

        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostDAO mapper = sqlSession.getMapper(PostDAO.class);
        List<PostVO> result = mapper.selectPostWithImage(map);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
