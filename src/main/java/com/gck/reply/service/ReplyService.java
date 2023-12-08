package com.gck.reply.service;


import com.gck.factory.MyBatisFactory;
import com.gck.reply.model.ReplyDAO;
import com.gck.reply.model.ReplyDTO;
import com.gck.reply.model.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ReplyService {

    SqlSession sqlSession;
    private ReplyDAO mapper;

    public ReplyService(){}

    // ArrayList -> JSON
    public JSONObject toJSONObject(ArrayList<ReplyDTO> replyDTOArrayList) {
        JSONObject obj = new JSONObject();
        try {
            JSONArray jArray = new JSONArray();// 댓글 배열. json 객체 배열

            // list 요소마다 json 객체 생성 & json array에 추가
            for (int i = 0; i < replyDTOArrayList.size(); i++) {
                JSONObject sObject = new JSONObject(); // 댓글 하나. 배열 내에 들어갈 json

                sObject.put("memberIdx", replyDTOArrayList.get(i).getMemberNickname());
                sObject.put("replyContent", replyDTOArrayList.get(i).getReplyContent());
                sObject.put("replyWriteDate", replyDTOArrayList.get(i).getReplyWriteDate());
                sObject.put("replyIdx", replyDTOArrayList.get(i).getReplyIdx());

                jArray.put(sObject);
            }

            obj.put("reply", jArray); // json array를 넣음
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return obj;
    }

    //댓글 리스트 JSON 불러오기
    public JSONObject getRepliesJSON (int postIdx) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(ReplyDAO.class);

        // postIdx 게시물에 작성된 댓글의
        // 작성자 회원 nickname, 댓글 내용, 댓글 작성일시를 불러온다.
        ArrayList<ReplyDTO> list = mapper.getReplies(postIdx);

        // 등록된 댓글이 없을 경우
        if(list.size() == 0){
            JSONObject obj = new JSONObject();
            sqlSession.close();
            return obj;
        }

        // list -> json
        JSONObject obj = toJSONObject(list);

        if(obj == null){
            obj = new JSONObject();
            sqlSession.close();
            return obj;
        }

        sqlSession.close();

        return obj;
    }

    //댓글 작성
    public int createReplies(String postIdxStr, String memberIdxStr, String replyContent) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(ReplyDAO.class);

        Integer postIdx = Integer.parseInt(postIdxStr);
        Integer memberIdx = Integer.parseInt(memberIdxStr);

        ReplyVO replyVO = new ReplyVO(postIdx, memberIdx, replyContent);

        Integer result = mapper.createReplies(replyVO);

        // insert 오류
        if (result == null || result != 1) {
            sqlSession.close();
            return -1;
        }

        // insert 성공
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    // 댓글 update
    public int updateReplies(ReplyVO replyVO) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(ReplyDAO.class);
        Integer result = mapper.updateReplies(replyVO);

        // update 오류
        if (result == null || result != 1) {
            sqlSession.close();
            return -1;
        }

        // update 성공
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    // 댓글 delete
    public int deleteReplies(ReplyVO replyVO) {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(ReplyDAO.class);

        Integer result = mapper.deleteReplies(replyVO);

        // update 오류
        if (result == null || result != 1) {
            sqlSession.close();
            return -1;
        }

        // update 성공
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}


