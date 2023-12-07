package com.gck.post.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PostImageDAO {

    List<PostImageVO> selectAllPostImageList(Map<String,Object> map);

    int insertPostImage(PostImageVO vo);

    int updatePostImage(PostImageVO vo);

    int deletePostImage(PostImageVO vo);

    ArrayList<PostImageVO> getPostImagesByPostIdx(int postIdx);
}

