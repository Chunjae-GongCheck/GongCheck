package com.gck.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// 게시판
@Data
@AllArgsConstructor
public class BoardVO {
    int boardIdx;               // 게시판 index
    String boardDescription;    // 게시판 설명
}
