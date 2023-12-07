package com.gck.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ** 관리자 비밀번호를 담는 VO 클래스입니다. **//

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordAdminVO {
    private int passwordAdminIdx;   // 비밀번호 index
    private int adminIdx;           // 관리자 index
    private String passwordAdmin;   // 비밀번호

    // 관리자 인덱스와 비밀번호를 받아서 PasswordAdminVO를 생성하는 생성자입니다.
    // adminIdx : 관리자 index
    // passwordAdmin : 비밀번호
    public PasswordAdminVO(int adminIdx, String passwordAdmin) {
        this.adminIdx = adminIdx;
        this.passwordAdmin = passwordAdmin;
    }
}