package com.gck.post.model;

import java.util.List;
import java.util.Map;

public interface PostDAO {
    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
<<<<<<< HEAD

    public List<PostVO> selectListMyPage(Map<String,Object> map);
=======
    public List<PostVO> selectListPage(Map<String, Object> map);
    public int selectCount(Map<String, Object> map);
>>>>>>> 56d413f1e0d64f7b8f31c1ba67491d806543229e
    public PostVO selectView(String postIdx);
    public int updateVisitCount(String postIdx);
    public int insertPost(PostVO vo);
    public int updatePost(PostVO vo);
    public int deletePost(int postIdx);
    public List<PostVO> selectPopupView(Map <String,Object> map);
}
