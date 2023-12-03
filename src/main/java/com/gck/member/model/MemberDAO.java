package com.gck.member.model;

import java.util.HashMap;

public interface MemberDAO {
    // 로그인 : id, pw에 맞는 idx를 찾는다.
    public Integer getMemberIdx(HashMap<String, String> map);
    // 회원가입 : id에 맞는 idx를 찾는다.
    public Integer getMemberIdxById(String memberId);
    // 회원가입 : 회원 등록
    public Integer insertMember(HashMap<String, String> map);
    // 회원가입 : id 중복 확인
    public Integer searchId(String memberId);
    // 회원가입 : 닉네임 중복 확인
    public Integer searchNickname(String memberNickname);
    // 회원가입 : 이메일 중복 확인
    public Integer searchEmail(String memberEmail);
    // 닉네임 조회
    public String getNickname(int memberIdx);
    // 회원 정보 수정 : 회원 정보 조회
    public MemberVO getMember(int memberIdx);
    // 회원 정보 수정
    public Integer updateMember(HashMap<String, String> map);
}
