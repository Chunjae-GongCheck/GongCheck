package com.gck.post.model;

import com.gck.board.model.BoardVO;

import java.util.List;

public interface PostDAO {
    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
    public List<BoardVO> selectListPage();
    public List<BoardVO> selectListMyPage();
    public PostVO selectView(String postIdx);
    public int updateVisitCount(String postIdx);
    public int insertPost(PostVO vo);
    public int updatePost(PostVO vo);
    public int deletePost(int postIdx);
}
