package com.gck.notice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

// 공지 게시판의 게시물
@Data
@AllArgsConstructor
public class NoticeVO {
    int noticeIdx;          // 게시물 index
    int boardIdx;           // 게시판 index
    String noticeTitle;     // 제목
    String noticeContent;   // 내용
    int adminIdx;           // 작성자 관리자 index
    Date noticeWriteDate;   // 작성일시
    Date noticeUpdateDate;  // 수정일시
    int noticeVisitcount;   // 조회수
}
