package com.gck.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// 이미지
@Data
@AllArgsConstructor
public class PostImageVO {
    int postImageIdx;       // 이미지 index
    int postIdx;            // 게시글 index
    String postImageOriginalname;   // 원래 이름
    String postImageSavedname;  // 서버에 저장된 이름

    public PostImageVO() {

    }
}
