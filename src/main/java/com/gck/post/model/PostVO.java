package com.gck.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

// 공부 인증 게시판의 게시물
@Data
@AllArgsConstructor
public class PostVO {
    private int postIdx;            // 게시물 index
    private int boardIdx;           // 게시판 index
    private String postTitle;       // 제목
    private String postContent;     // 내용
    private int memberIdx;          // 작성자 회원 idx
    private int postLikecount;      // 좋아요 수
    private Date postWriteDate;     // 작성일시
    private Date postUpdateDate;    // 수정일시
    private int postVisitcount;     // 조회수

    public PostVO() {

    }
}
