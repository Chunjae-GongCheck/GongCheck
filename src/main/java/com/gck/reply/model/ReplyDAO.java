package com.gck.reply.model;

import java.util.ArrayList;

public interface ReplyDAO {

    //댓글 목록 불러오기
    ArrayList<ReplyDTO> getReplies(int postIdx);

    //댓글 작성
    Integer createReplies(ReplyVO replyVO);

    //댓글 수정
    Integer updateReplies(ReplyVO replyVO);

    // 댓글 삭제
    Integer deleteReplies(ReplyVO replyVO);
}
