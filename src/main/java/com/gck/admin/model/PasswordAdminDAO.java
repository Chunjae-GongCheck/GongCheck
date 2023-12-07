package com.gck.admin.model;

import java.util.List;

// ** 비밀번호 관리자 DAO 인터페이스입니다. **//

public interface PasswordAdminDAO {

    // 특정 관리자의 비밀번호 목록을 조회하는 메소드입니다.
    List<PasswordAdminVO> selectPasswordAdminList(int adminIdx);

    // 비밀번호 관리자를 추가하는 메소드입니다.
    // 추가할 비밀번호 관리자의 정보를 파라미터로 전달받습니다.
    int insertPasswordAdmin(PasswordAdminVO passwordAdminVO);
}