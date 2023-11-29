package com.gck.post.model;

import java.util.HashMap;

public interface PostImageDAO {

//    public int getPostImageIdx(HashMap<String, Object> map);



    int updatePostImage(PostImageVO vo);

    int deletePostImage(PostImageVO vo);

}

