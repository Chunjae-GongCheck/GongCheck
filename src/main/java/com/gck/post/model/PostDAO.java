package com.gck.post.model;

import java.util.List;
import java.util.Map;

public interface PostDAO {
    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)


//    public List<PostVO> selectListMyPage(Map<String, Object> map);

//    public List<PostVO> selectListPage(Map<String, Object> map);

//    public int selectCount(Map<String, Object> map);

    public PostVO selectView(String postIdx);
    // 서버에 저장된 이미지 정보 조회
    List<PostVO> selectPostWithImage (Map<String, Object> map);

    public int updateVisitCount(String postIdx);

    public int insertPost(PostVO vo);

    int insertPostImage(PostVO vo);

    public int updatePost(PostVO vo);

    public int deletePost(int postIdx);
}
