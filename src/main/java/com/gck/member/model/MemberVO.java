package com.gck.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

// 회원
@Data
@AllArgsConstructor
public class MemberVO {
    private int memberIdx;                  // 회원 index
    private String memberId;                // 회원 ID
    private String memberNickname;          // 닉네임
    private Date memberRegdate;             // 가입일
    private String memberEmail;             // email
    private String memberImagePath;         // 프로필 사진 저장 경로
    private String memberZonecode;          // 우편번호
    private String memberAddress;           // 도로명 주소
    private String memberAddressDetailed;   // 상세주소
}
