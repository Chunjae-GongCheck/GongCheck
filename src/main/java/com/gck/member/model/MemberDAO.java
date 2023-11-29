package com.gck.member.model;

import java.util.HashMap;

public interface MemberDAO {
    // 로그인 : id, pw에 맞는 idx를 찾는다.
    public Integer getMemberIdx(HashMap<String, String> map);
    // 회원가입
    public Integer insertMember(String memberId, String memberNickname, String memberEmail, String memberZonecode, String memberAddress, String memberAddressDetailed);
}
