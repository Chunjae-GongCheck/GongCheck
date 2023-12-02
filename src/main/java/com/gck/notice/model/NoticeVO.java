package com.gck.notice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

// 공지 게시판의 게시물
@Data
@AllArgsConstructor
public class NoticeVO {
    private int noticeIdx;          // 게시물 index
    private int boardIdx;           // 게시판 index
    private String noticeTitle;     // 제목
    private String noticeContent;   // 내용
    private int adminIdx;           // 작성자 관리자 index
    private Date noticeWriteDate;   // 작성일시
    private Date noticeUpdateDate;  // 수정일시
    private int noticeVisitcount;   // 조회수
}
