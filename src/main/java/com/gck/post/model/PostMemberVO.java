package com.gck.post.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter @Setter
@NoArgsConstructor
@ToString
public class PostMemberVO {
    private int postIdx;            // 게시물 index
    private int boardIdx;           // 게시판 index
    private String postTitle;       // 제목
    private String postContent;     // 내용
    private int memberIdx;          // 작성자 회원 idx
    private int postLikecount;      // 좋아요 수
    private Date postWriteDate;     // 작성일시
    private Date postUpdateDate;    // 수정일시
    private int postVisitcount;     // 조회수
    private String memberNickname;
}
