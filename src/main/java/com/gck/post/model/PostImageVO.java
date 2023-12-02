package com.gck.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// 이미지
@Data
@AllArgsConstructor
public class PostImageVO {
    private int postImageIdx;       // 이미지 index
    private int postIdx;            // 게시글 index
    private String postImagePath;   // 원래 이름
    private String postTImagePath;  // 서버에 저장된 이름

    public PostImageVO() {

    }
}
