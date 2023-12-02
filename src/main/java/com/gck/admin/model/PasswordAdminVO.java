package com.gck.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// 관리자 비밀번호
@Data
@AllArgsConstructor
public class PasswordAdminVO {
    private int passwordAdminIdx;   // 비밀번호 index
    private int adminIdx;           // 관리자 index
    private String passwordAdmin;   // 비밀번호
}
