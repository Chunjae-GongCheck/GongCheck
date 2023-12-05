package com.gck.post.model;


public interface LikesDAO {
    // 좋아요 입력 여부 조회
    public Integer getPostLikes(LikesVO likesVO);
    // 좋아요 등록
    public Integer insertLikes(LikesVO likesVO);
    // 좋아요 삭제
    public Integer deleteLikes(LikesVO likesVO);

    // 게시물 좋아요 수 증가
    public Integer increaseLikes(int postIdx);
    // 게시물 좋아요 수 감소
    public Integer decreaseLikes(int postIdx);
}
