package com.gck.member.service;

import com.gck.encryption.Sha256;
import com.gck.factory.MyBatisFactory;
import com.gck.member.model.MemberDAO;
import com.gck.member.model.PasswordMemberDAO;
import org.apache.ibatis.session.SqlSession;
import java.util.HashMap;


public class MemberService {
    // DAO
    SqlSession sqlSession;
    MemberDAO mapperMembers;
    PasswordMemberDAO mapperPasswordMembers;

    // 생성자
    public MemberService(){}

    // 회원 id로 회원 idx 검색
    // memberId, passwordMember에 맞는 회원의 Idx를 리턴. 없으면 -1 리턴
    public int getMemberIdx(String memberId, String passwordMember){
        Integer memberIdx = null;

        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperMembers = this.sqlSession.getMapper(MemberDAO.class);

            // 비밀번호 암호화
            String encryptedPasswordMember = Sha256.getHash(passwordMember, memberId);
            System.out.println("encryptedPasswordMember : " + encryptedPasswordMember);
            HashMap<String, String> map = new HashMap<>();
            map.put("memberId", memberId);
            map.put("passwordMember", encryptedPasswordMember);

            // memberId, passwordMember에 맞는 회원이 없으면 null을 리턴받는다.
            memberIdx = mapperMembers.getMemberIdx(map);

            sqlSession.close();
        }catch(Exception e){
            System.out.println("MemberService_exception");
        }finally {
            // memberId, passwordMember에 맞는 회원이 없어서 null을 리턴받으면 -1 리턴
            return (memberIdx != null) ? memberIdx.intValue() : -1;
        }
    }

    // 회원가입
    // 회원가입 성공 시, true 리턴. 실패 시, false 리턴
    public boolean signup(String memberId, String passwordMember, String memberNickname, String memberEmail, String memberZonecode, String memberAddress, String memberAddressDetailed){
        boolean result = false;
        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperMembers = this.sqlSession.getMapper(MemberDAO.class);
            mapperPasswordMembers = this.sqlSession.getMapper(PasswordMemberDAO.class);

            // 비밀번호 암호화
            String encryptedPasswordMember = Sha256.getHash(passwordMember, memberId);
            System.out.println("encryptedPasswordMember : " + encryptedPasswordMember);
            HashMap<String, String> map = new HashMap<>();
            map.put("memberId", memberId);
            map.put("passwordMember", encryptedPasswordMember);
            map.put("memberNickname", memberNickname);
            map.put("memberEmail", memberEmail);
            map.put("memberZonecode", memberZonecode);
            map.put("memberAddress", memberAddress);
            map.put("memberAddressDetailed", memberAddressDetailed);

            Integer resultInsertMember = mapperMembers.insertMember(memberId, memberNickname, memberEmail, memberZonecode, memberAddress, memberAddressDetailed);
            mapperPasswordMembers.insertPassword(memberId, encryptedPasswordMember);

            sqlSession.close();
        }catch (Exception e){
            System.out.println("MemberService_exception");
        }finally {
            return result;
        }
    }
}
