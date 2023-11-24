package com.gck.reply.model;

import java.util.List;
import java.util.Map;


public interface ReplyDAO {
    List<ReplyVO> getReplies(Map<String, Object> map);

}
