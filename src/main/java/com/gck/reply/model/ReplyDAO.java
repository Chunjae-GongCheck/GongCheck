package com.gck.reply.model;

import java.util.List;
import java.util.Map;


public interface ReplyDAO {

    //댓글 목록 불러오기
    List<ReplyVO> getRepliesByPost(int postIdx);

    //댓글 작성
    int createReplies(ReplyVO vo);


    // 삽입, 업데이트, 삭제 추가 예정
}
