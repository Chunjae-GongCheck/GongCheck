package com.gck.admin.service;

import com.gck.admin.model.AdminDAO;
import com.gck.admin.model.AdminVO;
import com.gck.encryption.Sha256;
import com.gck.factory.MyBatisFactory;
import com.gck.member.model.MemberDAO;
import lombok.Data;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class AdminBoardService {

    SqlSession sqlSession;
    AdminDAO mapperAdmins;
    public int getAdminIdx(String adminId , String passwordAdmin){
        System.out.println("getAdminIdx Test");
        Integer adminIdx = null;

        try {
            this.sqlSession = MyBatisFactory.getSqlSession();
            mapperAdmins = this.sqlSession.getMapper(AdminDAO.class);

            // 비밀번호 암호화
//            String encryptedPasswordMember = Sha256.getHash(passwordMember, memberId);
            HashMap<String, String> map = new HashMap<>();
            map.put("adminId", adminId);
            map.put("passwordAdmin", passwordAdmin);

            // memberId, passwordMember에 맞는 회원이 없으면 null을 리턴받는다.
            adminIdx = mapperAdmins.getAdminIdx(map);
        }catch(Exception e){
            System.out.println("AdminService_exception");
        }finally {
            sqlSession.close();
            // memberId, passwordMember에 맞는 회원이 없어서 null을 리턴받으면 -1 리턴
            return (adminIdx != null) ? adminIdx.intValue() : -1;
        }
    }

    public List<AdminVO> selectMemberList(Map<String,Object> map){

        return null;
    }



}
