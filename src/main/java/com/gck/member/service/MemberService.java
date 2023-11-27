package com.gck.member.service;

import com.gck.encryption.Sha256;
import com.gck.factory.MyBatisFactory;
import com.gck.member.model.MemberDAO;
import org.apache.ibatis.session.SqlSession;
import java.util.HashMap;


public class MemberService {
    // DAO
    SqlSession sqlSession;
    MemberDAO mapper;

    // 생성자
    public MemberService(){}

    // memberId, passwordMember에 맞는 회원의 Idx를 리턴. 없으면 -1 리턴
    public int getMemberIdx(String memberId, String passwordMember){
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(MemberDAO.class);

        // 비밀번호 암호화
        String encryptedPasswordMember = Sha256.getHash(passwordMember);
        System.out.println("getMemberIdx : "+encryptedPasswordMember);
        HashMap<String, String> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("passwordMember", encryptedPasswordMember);

        // memberId, passwordMember에 맞는 회원이 없으면 null을 리턴받는다.
        Integer memberIdx = mapper.getMemberIdx(map);

        sqlSession.close();

        // memberId, passwordMember에 맞는 회원이 없어서 null을 리턴받으면 -1 리턴
        return (memberIdx != null) ? memberIdx.intValue() : -1;
    }
}
