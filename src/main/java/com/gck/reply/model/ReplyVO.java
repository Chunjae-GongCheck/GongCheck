package com.gck.reply.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

// 댓글
@Data
@AllArgsConstructor
public class ReplyVO {
    private int replyIdx;           // 댓글 index
    private int postIdx;            // 게시물 index
    private String replyContent;    // 댓글 내용
    private int memberIdx;          // 작성자 index
    private Date replyWriteDate;    // 작성일시
    private Date replyUpdateDate;   // 수정일시
    private int replyParentNo;      // 부모글
    private int replyDepthNo;       // 계층
    private int replyOrderid;       // 같은 그룹 정렬

    public ReplyVO() {
    }

    public ReplyVO(int postIdx, int memberIdx, String replyContent){
        this.postIdx = postIdx;
        this.memberIdx = memberIdx;
        this.replyContent = replyContent;
    }
}
