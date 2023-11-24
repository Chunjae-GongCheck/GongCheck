package com.gck.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// 이미지
@Data
@AllArgsConstructor
public class PostImageVO {
    int postImageIdx;       // 이미지 index
    int postIdx;            // 게시글 index
    String postImagePath;   // 이미지 저장 경로
    String postTImagePath;  // 썸네일 이미지 저장 경로
}
