package com.gck.post.model;

import java.util.HashMap;
import java.util.List;

public interface PostImageDAO {

    List<PostImageVO> getPostImageIdx(HashMap<String, Object> map);

    int insertPostImage(PostImageVO vo);

    int updatePostImage(PostImageVO vo);

    int deletePostImage(PostImageVO vo);


}

