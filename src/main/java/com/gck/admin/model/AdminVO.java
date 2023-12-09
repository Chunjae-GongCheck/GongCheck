package com.gck.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

// 관리자
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AdminVO {
    // password_admins 테이블
    private int passwordAdminIdx;       // 관리자 index
    private String passwordAdmin; //
    // admins 테이블
    private String adminId;
    private int adminIdx; // 관리자 id -> password admins  외래키
    // members 테이블
    private int memberIdx;                  // 회원 index
    private String memberId;                // 회원 ID
    private String memberNickname;          // 닉네임
    private Date memberRegdate;             // 가입일
    private String memberEmail;             // email
    private String memberImagePath;         // 프로필 사진 저장 경로
    private String memberZonecode;          // 우편번호
    private String memberAddress;           // 도로명 주소
    private String memberAddressDetailed;   // 상세주소
    // password_members 테이블
    private int passwordMemberIdx;  // 비밀번호 index
    private String passwordMember;  // 비밀번호

}
