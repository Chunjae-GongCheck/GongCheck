package com.gck.reply.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

// 작성자 닉네임, 댓글 내용, 댓글 작성일시
@Data
@AllArgsConstructor
public class ReplyDTO {
    private int replyIdx;           // 댓글 index
    private String memberNickname;     // 회원 닉네임
    private String replyContent;    // 댓글 내용
    private Date replyWriteDate;    // 작성일시
}
