package com.gck.board.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BoardDAO {
    public List<BoardVO> selectListPage(Map<String,Object> map);
    public int selectCount (Map<String,Object> map);
    public String selectNickView(Map<String , Object> map);
}
