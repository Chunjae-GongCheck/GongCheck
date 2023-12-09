package com.gck.admin.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminDAO {

    public List<AdminVO> selectMemberList(Map<String,Object> map);

    public int getAdminIdx(HashMap<String, String> map);
}
