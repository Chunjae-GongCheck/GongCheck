package com.gck.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

// 공부 인증 게시판의 게시물
@Data
@AllArgsConstructor
public class PostVO {
    int postIdx;            // 게시물 index
    int boardIdx;           // 게시판 index
    String postTitle;       // 제목
    String postContent;     // 내용
    int memberIdx;          // 작성자 회원 idx
    int postLikecount;      // 좋아요 수
    Date postWriteDate;     // 작성일시
    Date postUpdateDate;    // 수정일시
    int postVisitcount;     // 조회수

// selectPostWithImage 메서드를 위해 추가 필드 선언
    int postImageIdx;       // 이미지 index
    String postImagePath;   // 원래 이름
    String postTImagePath;  // 서버에 저장된 이름
    public PostVO() {

    }
}
