package com.gck.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

// 게시판
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
    int postIdx;            // 게시물 index
    int boardIdx;           // 게시판 index
    String postTitle;       // 제목
    String postContent;     // 내용
    int memberIdx;          // 작성자 회원 idx
    int postLikecount;      // 좋아요 수
    Date postWriteDate;     // 작성일시
    Date postUpdateDate;    // 수정일시
    int postVisitcount;     // 조회수
    String boardDescription;    // 게시판 설명
    // postImage의 정보도 필요해서 추가

}
