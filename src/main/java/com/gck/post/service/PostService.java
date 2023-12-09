package com.gck.post.service;

import com.gck.factory.MyBatisFactory;
import com.gck.post.model.LikesDAO;
import com.gck.post.model.LikesVO;
import com.gck.post.model.PostDAO;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


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
    public JSONObject insertLikes(String postIdx, String memberIdx){
        int result = -1;
        JSONObject obj = new JSONObject();
        try {
            sqlSession = MyBatisFactory.getSqlSession();
            mapperLikes = this.sqlSession.getMapper(LikesDAO.class);

            int postIdxInt = Integer.parseInt(postIdx);
            int memberIdxInt = Integer.parseInt(memberIdx);

            LikesVO likesVO = new LikesVO(postIdxInt, memberIdxInt);

            // 추천 등록
            Integer queryResult = mapperLikes.insertLikes(likesVO);

            if(queryResult == null || queryResult != 1){    // 오류
                result = -1;
            }else{  // 좋아요 등록
                result = 0;
            }

            // 추천 등록 성공 시에만 실행
            if(result == 0) {
                // 게시물 추천 수 증가
                Integer increaseResult = mapperLikes.increaseLikes(postIdxInt);

                if (increaseResult == null || increaseResult != 1) {    // 오류
                    result = -1;
                } else {
                    result = 0;
                    sqlSession.commit();
                }
            }

            // 게시물 추천수 조회
            int cntLikes = countLikes(postIdxInt);

            // json 객체 생성
            obj = toJSONObject(result, cntLikes);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("MemberService_exception");
        }finally {
            sqlSession.close();
            return obj;
        }
    }

    // 추천 감소
    public JSONObject deleteLikes(String postIdx, String memberIdx){
        int result = -1;
        JSONObject obj = new JSONObject();
        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperLikes = this.sqlSession.getMapper(LikesDAO.class);

            int postIdxInt = Integer.parseInt(postIdx);
            int memberIdxInt = Integer.parseInt(memberIdx);

            LikesVO likesVO = new LikesVO(postIdxInt, memberIdxInt);

            // 추천 삭제
            Integer queryResult = mapperLikes.deleteLikes(likesVO);

            if(queryResult == null || queryResult != 1){    // 오류
                result = -1;
            }else{  // 추천 감소
                result = 1;
            }

            if (result == 1) {   // 추천 삭제 성공 시에만 진행
                // 게시물 추천 수 감소
                Integer decreaseResult = mapperLikes.decreaseLikes(postIdxInt);

                if (decreaseResult == null || decreaseResult != 1) {    // 오류
                    result = -1;
                } else {
                    result = 1;
                    sqlSession.commit();
                }
            }
            // 게시물 추천수 조회
            int cntLikes = countLikes(postIdxInt);

            // json 객체 생성
            obj = toJSONObject(result, cntLikes);

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("MemberService_exception");
        }finally {
            sqlSession.close();
            return obj;
        }
    }

    // 결과 json 객체 생성
    public JSONObject toJSONObject(int result, int cntLikes){
        JSONObject obj = new JSONObject();

        try {
            obj.put("result", result);
            obj.put("cntLikes", cntLikes);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj;
    }

    // 게시물의 좋아요 수 조회
    public int countLikes(int postIdx){
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapperLikes = this.sqlSession.getMapper(LikesDAO.class);

        int result = mapperLikes.countLikes(postIdx);

        sqlSession.close();
        return result;
    }
}
