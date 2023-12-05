package com.gck.admin.model;

import java.util.List;

public interface AdminDAO { 

    List<AdminVO> selectAdminList();
    int deleteAdmin(String adminId);

    AdminVO selectAdmin(String adminId);
}
