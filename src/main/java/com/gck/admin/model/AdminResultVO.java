package com.gck.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// ** 회원정보를 처리(조회, 결과)하기 위한 관리자 VO 클래스입니다. **//

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResultVO {
    private int adminIdx;       // 관리자 index
    private String adminId;     // 관리자 id
    private int passwordAdminIdx;   // 비밀번호 index
    private String passwordAdmin;   // 비밀번호

    // AdminVO와 PasswordAdminVO를 받아서 AdminResultVO를 생성하는 생성자입니다.
    // adminVO : 관리자 정보
    // passwordAdminVO : 비밀번호 정보


}
