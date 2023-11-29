package com.gck.post.model;

import com.gck.factory.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

public class PostImageDAOImpl implements PostImageDAO {
    @Override
    public int getPostImageIdx(HashMap<String, Object> map) {
        return 0;
    }

    @Override
    public int insertPostImage(PostImageVO vo) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostImageDAO mapper = sqlSession.getMapper(PostImageDAO.class);
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

    @Override
    public int updatePostImage(PostImageVO vo) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostImageDAO mapper = sqlSession.getMapper(PostImageDAO.class);
        int result = mapper.updatePostImage(vo);
        if (result == 1) {
            System.out.println("PostImage가 성공적으로 수정되었습니다.");
            sqlSession.commit();
        } else {
            System.out.println("PostImage 수정 실패.");
        }
        sqlSession.close();
        return result;
    }

    @Override
    public int deletePostImage(PostImageVO vo) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        PostImageDAO mapper = sqlSession.getMapper(PostImageDAO.class);
        int result = mapper.deletePostImage(vo);
        if (result == 1) {
            System.out.println("PostImage가 성공적으로 삭제되었습니다.");
            sqlSession.commit();
        } else {
            System.out.println("PostImage 삭제 실패.");
        }
        sqlSession.close();
        return result;
    }
}
