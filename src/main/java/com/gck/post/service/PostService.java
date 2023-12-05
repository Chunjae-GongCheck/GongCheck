package com.gck.post.service;

import com.gck.factory.MyBatisFactory;
import com.gck.post.model.LikesDAO;
import com.gck.post.model.LikesVO;
import com.gck.post.model.PostDAO;
import org.apache.ibatis.session.SqlSession;


public class PostService {
    // DAO
    SqlSession sqlSession;
    LikesDAO mapperLikes;
    PostDAO mapperPost;

    // 생성자
    public PostService(){}

    // 게시물 좋아요(추천) 여부 확인
    public int getPostLikes(String postIdx, String memberIdx){
        int result = -1;    // -1 오류 / 0 추천한 적 없음 / 1 추천한 적 있음
        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperLikes = this.sqlSession.getMapper(LikesDAO.class);

            int postIdxInt = Integer.parseInt(postIdx);
            int memberIdxInt = Integer.parseInt(memberIdx);

            LikesVO likesVO = new LikesVO(postIdxInt, memberIdxInt);

            // postIdx에 memberIdx가 좋아요를 누른 횟수
            Integer queryResult = mapperLikes.getPostLikes(likesVO);

            if(queryResult == null){    // 오류
                result = -1;
            }else if(queryResult.intValue() == 1){  // 추천한 적 있음
                result = 1;
            }else{  // 추천한 적 없음
                result = 0;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("MemberService_exception");
        }finally {
            sqlSession.close();
            return result;
        }
    }

    // 추천 증가
    public boolean insertLikes(String postIdx, String memberIdx){
        boolean result = false;
        try {
            sqlSession = MyBatisFactory.getSqlSession();
            mapperLikes = this.sqlSession.getMapper(LikesDAO.class);

            int postIdxInt = Integer.parseInt(postIdx);
            int memberIdxInt = Integer.parseInt(memberIdx);

            LikesVO likesVO = new LikesVO(postIdxInt, memberIdxInt);

            // 추천 등록
            Integer queryResult = mapperLikes.insertLikes(likesVO);

            if(queryResult == null || queryResult != 1){    // 오류
                result = false;
            }else{  // 좋아요 등록
                result = true;
            }

            // 게시물 추천 수 증가
            Integer increaseResult = mapperLikes.increaseLikes(postIdxInt);

            if(increaseResult == null || increaseResult != 1){    // 오류
                result = false;
            }else{
                result = true;
                sqlSession.commit();
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("MemberService_exception");
        }finally {
            sqlSession.close();
            return result;
        }
    }

    // 추천 감소
    public boolean deleteLikes(String postIdx, String memberIdx){
        boolean result = false;
        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperLikes = this.sqlSession.getMapper(LikesDAO.class);

            int postIdxInt = Integer.parseInt(postIdx);
            int memberIdxInt = Integer.parseInt(memberIdx);

            LikesVO likesVO = new LikesVO(postIdxInt, memberIdxInt);

            // 추천 삭제
            Integer queryResult = mapperLikes.deleteLikes(likesVO);

            if(queryResult == null || queryResult != 1){    // 오류
                result = false;
            }else{  // 추천 감소
                result = true;
            }

            // 게시물 추천 수 감소
            Integer decreaseResult = mapperLikes.decreaseLikes(postIdxInt);

            if(decreaseResult == null || decreaseResult != 1){    // 오류
                result = false;
            }else{
                result = true;
                sqlSession.commit();
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("MemberService_exception");
        }finally {
            sqlSession.close();
            return result;
        }
    }
}
