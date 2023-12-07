package com.gck.admin.model;

import java.util.List;

// ** 회원정보를 처리하기 위한 관리자 DAO 인터페이스입니다. **//

public interface AdminDAO {


    // 회원정보를 조회하는 메소드입니다.
    // 조회 결과는 AdminResultVO 객체에 저장되어 반환됩니다.
    List<AdminVO> selectAdminList();

    // 회원정보를 삭제하는 메소드입니다.
    // 삭제할 회원의 idx를 파라미터로 전달받습니다.
    int deleteAdmin(String adminId);

    // 회원정보를 수정하는 메소드입니다.
    // 수정할 회원의 idx와 새로운 비밀번호를 파라미터로 전달받습니다.
    AdminVO selectAdmin(String adminId);
}
