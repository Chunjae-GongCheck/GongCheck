package com.gck.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikesVO {
    private int postIdx;    // 게시물 idx
    private int memberIdx;  // 회원 idx
}
