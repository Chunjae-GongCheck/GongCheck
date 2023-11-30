package com.gck.reply.model;

import java.util.List;
import java.util.Map;


public interface ReplyDAO {
    List<ReplyVO> getRepliesByPost(int postIdx);
    // 삽입, 업데이트, 삭제 추가 예정
}
