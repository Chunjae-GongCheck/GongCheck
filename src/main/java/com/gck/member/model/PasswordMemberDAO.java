package com.gck.member.model;

public interface PasswordMemberDAO {
    // 회원가입
    public Integer insertPassword(String memberId, String encryptedPasswordMember);
}
