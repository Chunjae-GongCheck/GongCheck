package com.gck.admin.model;

import java.util.List;

public interface PasswordAdminDAO { 

    public List<PasswordAdminVO> selectPasswordAdminList(int adminIdx);

    int insertPasswordAdmin(PasswordAdminVO passwordAdminVO);
}
