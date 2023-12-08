package com.gck.member.model;

import lombok.Data;

@Data
public class MemberResultVO {

    private int memberIdx;                  // 회원 index
    private String memberId;                // 회원 ID
    private String memberNickname;          // 닉네임
    private String passwordMember;  // 비밀번호

    public MemberResultVO(MemberVO memberVO, PasswordMemberVO passwordMemberVO) {
        this.memberIdx = memberVO.getMemberIdx();
        this.memberId = memberVO.getMemberId();
        this.memberNickname = memberVO.getMemberNickname();
        this.passwordMember = passwordMemberVO.getPasswordMember();

    }
}
