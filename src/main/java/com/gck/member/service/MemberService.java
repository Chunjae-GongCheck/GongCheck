package com.gck.member.service;

import com.gck.encryption.Sha256;
import com.gck.factory.MyBatisFactory;
import com.gck.member.model.MemberDAO;
import com.gck.member.model.MemberVO;
import com.gck.member.model.PasswordMemberDAO;
import com.gck.member.model.PasswordMemberVO;
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
            HashMap<String, String> map = new HashMap<>();
            map.put("memberId", memberId);
            map.put("passwordMember", encryptedPasswordMember);

            // memberId, passwordMember에 맞는 회원이 없으면 null을 리턴받는다.
            memberIdx = mapperMembers.getMemberIdx(map);
        }catch(Exception e){
            System.out.println("MemberService_exception");
        }finally {
            sqlSession.close();
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

            // map에 회원정보 입력
            HashMap<String, String> map = new HashMap<>();
            map.put("memberId", memberId);
            // map.put("passwordMember", encryptedPasswordMember);
            map.put("memberNickname", memberNickname);
            map.put("memberEmail", memberEmail);
            map.put("memberZonecode", memberZonecode);
            map.put("memberAddress", memberAddress);
            map.put("memberAddressDetailed", memberAddressDetailed);

            // null 확인
            for(String m : map.values()){
                if(m == null)   return false; // null 입력 받을 경우, false 리턴
            }
            if(passwordMember == null)  return false;

            // 비밀번호 제외한 회원 정보 insert
            Integer resultInsertMember = mapperMembers.insertMember(map);
            // insert 실패
            if(resultInsertMember == null || resultInsertMember != 1){
                sqlSession.close();
                return result;
            }

            // 회원 idx 조회
            Integer memberIdx = mapperMembers.getMemberIdxById(memberId);
            // 조회 실패
            if(memberIdx == null){
                sqlSession.close();
                return result;
            }

            // 비밀번호 암호화
            String encryptedPasswordMember = Sha256.getHash(passwordMember, memberId);
            System.out.println("encryptedPasswordMember : " + encryptedPasswordMember);

            // 회원 비밀번호 객체 생성
            PasswordMemberVO passwordMemberVO = new PasswordMemberVO(memberIdx.intValue(), encryptedPasswordMember);

            // 비밀번호 insert
            Integer resultInsertPassword = mapperPasswordMembers.insertPassword(passwordMemberVO);
            // insert 실패
            if(resultInsertPassword == null || resultInsertPassword != 1) {
                sqlSession.close();
                return result;
            }

            // 회원가입 성공
            result = true;
        }catch (Exception e){
            System.out.println("MemberService_exception_signup");
        }finally {
            sqlSession.commit();
            sqlSession.close();
            return result;
        }
    }

    // id 중복 확인
    public boolean searchId(String memberId){
        // true 리턴 : 중복 O / false 리턴 : 중복 X
        // boolean exists = getMemberService().searchId(memberId);
        boolean result = true;

        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperMembers = this.sqlSession.getMapper(MemberDAO.class);

            // id 개수 조회
            Integer exists = mapperMembers.searchId(memberId);

            if(exists == null || exists.intValue() != 0){ // 오류 || 중복 O
                // result = true;
            }else if(exists.intValue() == 0){ // 중복 X
                result = false;
            }
        }catch (Exception e){
            System.out.println("MemberService_exception_searchId");
        }finally {
            sqlSession.close();
            return result;
        }
    }

    // 닉네임 중복 확인
    public boolean searchNickname(String memberNickname){
        // true 리턴 : 중복 O / false 리턴 : 중복 X
        // boolean exists = getMemberService().searchId(memberId);
        boolean result = true;

        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperMembers = this.sqlSession.getMapper(MemberDAO.class);

            // Nickname 개수 조회
            Integer exists = mapperMembers.searchNickname(memberNickname);

            if(exists == null || exists.intValue() != 0){ // 오류 || 중복 O
                // result = true;
            }else if(exists.intValue() == 0){ // 중복 X
                result = false;
            }
        }catch (Exception e){
            System.out.println("MemberService_exception_searchNickname");
        }finally {
            sqlSession.close();
            return result;
        }
    }

    // 이메일 중복 확인
    public boolean searchEmail(String memberEmail){
        // true 리턴 : 중복 O / false 리턴 : 중복 X
        // boolean exists = getMemberService().searchId(memberId);
        boolean result = true;

        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperMembers = this.sqlSession.getMapper(MemberDAO.class);

            // memberEmail 개수 조회
            Integer exists = mapperMembers.searchEmail(memberEmail);

            if(exists == null || exists.intValue() != 0){ // 오류 || 중복 O
                // result = true;
            }else if(exists.intValue() == 0){ // 중복 X
                result = false;
            }
        }catch (Exception e){
            System.out.println("MemberService_exception_memberEmail");
        }finally {
            sqlSession.close();
            return result;
        }
    }

    // 닉네임 조회
    public String getNickname(int memberIdx){
        String memberNickname = "";
        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperMembers = this.sqlSession.getMapper(MemberDAO.class);

            // memberNickname 조회
            memberNickname = mapperMembers.getNickname(memberIdx);

            if(memberNickname == null){ // 오류
                memberNickname = "";
            }
        }catch (Exception e){
            System.out.println("MemberService_exception_memberEmail");
        }finally {
            sqlSession.close();
            return memberNickname;
        }
    }

    // 회원 정보 조회
    public MemberVO getMember(String memberIdxStr){
        if(memberIdxStr == null)   return null;

        int memberIdx = (int)Integer.parseInt(memberIdxStr);
        MemberVO memberVo = null;

        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperMembers = this.sqlSession.getMapper(MemberDAO.class);

            // memberVO 조회
            memberVo = mapperMembers.getMember(memberIdx);

            if(memberVo == null){ // 오류
                // return null;
            }
        }catch (Exception e){
            System.out.println("MemberService_exception_getMember");
        }finally {
            sqlSession.close();
            return memberVo;
        }
    }

    // 회원 정보 수정
    public boolean updateMember(HashMap<String, String> map){
        // 리턴 결과값
        boolean result = false;
        // 수정 결과
        Integer updateResult = 0;

        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperMembers = this.sqlSession.getMapper(MemberDAO.class);

            // map 값 중에서 null이 있는지 확인
            for(String v: map.values()){
                if(v == null){
                    sqlSession.close();
                    return false;
                }
            }

            // memberVO 조회
            updateResult = mapperMembers.updateMember(map);

            // 실패
            if(updateResult == null || updateResult.intValue() != 1){
                result = false;
            }else {// update 성공
                result = true;
            }
        }catch (Exception e){
            System.out.println("MemberService_exception_getMember");
        }finally {
            sqlSession.commit();
            sqlSession.close();
            return result;
        }
    }
}
