package com.gck.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// 회원 비밀번호
@Data
@AllArgsConstructor
public class PasswordMemberVO {
    private int passwordMemberIdx;  // 비밀번호 index
    private int memberIdx;          // 회원 index
    private String passwordMember;  // 비밀번호

    public PasswordMemberVO(int memberIdx, String passwordMember){
        this.memberIdx = memberIdx;
        this.passwordMember = passwordMember;
    }
}