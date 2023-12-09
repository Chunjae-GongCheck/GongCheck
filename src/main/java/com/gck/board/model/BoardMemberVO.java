package com.gck.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

// 게시판
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardMemberVO {
    private int postIdx;                // 게시물 index
    private int boardIdx;               // 게시판 index
    private String postTitle;           // 제목
    private String postContent;         // 내용
    private int memberIdx;              // 작성자 회원 idx
    private int postLikecount;          // 좋아요 수
    private Date postWriteDate;         // 작성일시
    private Date postUpdateDate;        // 수정일시
    private int postVisitcount;         // 조회수
    private String boardDescription;    // 게시판 설명
    // member 정보도 필요해서 추가
    private String memberNickname;
}
