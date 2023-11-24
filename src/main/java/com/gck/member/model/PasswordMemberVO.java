package com.gck.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// 회원 비밀번호
@Data
@AllArgsConstructor
public class PasswordMemberVO {
    int passwordMemberIdx;  // 비밀번호 index
    int memberIdx;          // 회원 index
    String passwordMember;  // 비밀번호
}