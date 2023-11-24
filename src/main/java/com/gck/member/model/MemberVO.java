package com.gck.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

// 회원
@Data
@AllArgsConstructor
public class MemberVO {
    int memberIdx;                  // 회원 index
    String memberId;                // 회원 ID
    String memberNickname;          // 닉네임
    Date memberRegdate;             // 가입일
    String memberEmail;             // email
    String memberImagePath;         // 프로필 사진 저장 경로
    String memberZonecode;          // 우편번호
    String memberAddress;           // 도로명 주소
    String memberAddressDetailed;   // 상세주소
}
