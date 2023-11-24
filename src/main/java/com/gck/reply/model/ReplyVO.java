package com.gck.reply.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

// 댓글
@Data
@AllArgsConstructor
public class ReplyVO {
    int replyIdx;           // 댓글 index
    int postIdx;            // 게시물 index
    String replyContent;    // 댓글 내용
    int memberIdx;          // 작성자 index
    Date replyWriteDate;    // 작성일시
    Date replyUpdateDate;   // 수정일시
    int replyParentNo;      // 부모글
    int replyDepthNo;       // 계층
    int replyOrderid;       // 같은 그룹 정렬
}
