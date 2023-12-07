package com.gck.admin.service;

import com.gck.admin.model.*;
import com.gck.factory.MyBatisFactory;
import lombok.Data;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// ** 관리자 가입회원 List 서비스 클래스입니다. **//

@Data
public class AdminBoardService {


    //가입회원 목록을 조회하는 메소드입니다.
    public List<AdminResultVO> selectAdminList() {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
        PasswordAdminDAO passwordAdminDAO = sqlSession.getMapper(PasswordAdminDAO.class);

        List<AdminResultVO> adminResultVOS = new ArrayList<>();

        List<AdminVO> adminVOS = adminDAO.selectAdminList();

        for(AdminVO adminVo : adminVOS) {
            List<PasswordAdminVO> passwordAdminVOS
                    = passwordAdminDAO.selectPasswordAdminList(adminVo.getAdminIdx());

            if (passwordAdminVOS != null && passwordAdminVOS.size() > 0)
                adminResultVOS.add(new AdminResultVO(adminVo, passwordAdminVOS.get(0)));
        }

        return adminResultVOS;
    }

    // 가입회원을 삭제하는 메소드입니다.

    public void deleteAdmin(String adminId) {
        SqlSession sqlSession = MyBatisFactory.getSqlSession();
        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);

        if (adminId == null || adminId.isEmpty()) {
            throw new IllegalArgumentException("adminId is not null");
        }

        int result = adminDAO.deleteAdmin(adminId);
        if (result == 1) {

            //삭제 성공 시 commit
            sqlSession.commit();
        }
    }

    //가입회원을 조회하는 메소드입니다.
    public AdminResultVO selectAdmin(String adminId) {

        // MyBatis를 사용하여 SQL 세션을 가져옵니다.
        SqlSession sqlSession = MyBatisFactory.getSqlSession();

        // AdminDAO와 PasswordAdminDAO를 매퍼로 등록합니다.
        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
        PasswordAdminDAO passwordAdminDAO = sqlSession.getMapper(PasswordAdminDAO.class);

        // 관리자 정보를 조회합니다.
        AdminVO adminVo = adminDAO.selectAdmin(adminId);

        // 관리자의 비밀번호 정보를 조회합니다.
        PasswordAdminVO passwordAdminVO =
                passwordAdminDAO.selectPasswordAdminList(adminVo.getAdminIdx())
                        .stream().findFirst().orElseGet(PasswordAdminVO::new);

        // 조회된 관리자 정보와 비밀번호 정보를 AdminResultVO로 묶어서 반환합니다.
        return new AdminResultVO(adminVo, passwordAdminVO);
    }

    //가입회원 정보를 수정 및 업데이트하는 메소드입니다.
    // adminId : 관리자 id
    // passwordOrig : 기존 비밀번호
    // passwordNew : 새로운 비밀번호
    public void updateAdmin(String adminId, String passwordOrig, String passwordNew) {

        // MyBatis를 사용하여 SQL 세션을 가져옵니다.
        SqlSession sqlSession = MyBatisFactory.getSqlSession();

        // AdminDAO와 PasswordAdminDAO를 매퍼로 등록합니다.
        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
        PasswordAdminDAO passwordAdminDAO = sqlSession.getMapper(PasswordAdminDAO.class);

        // 관리자 정보를 조회합니다.
        AdminVO adminVo = adminDAO.selectAdmin(adminId);

        // 관리자의 비밀번호 정보를 조회합니다.
        PasswordAdminVO passwordAdminVO =
                passwordAdminDAO.selectPasswordAdminList(adminVo.getAdminIdx())
                        .stream().findFirst().orElseGet(PasswordAdminVO::new);

        // 기존 비밀번호와 입력한 기존 비밀번호가 다를 경우 예외를 발생시킵니다.
        if (!Objects.equals(passwordAdminVO.getPasswordAdmin(), passwordOrig)) {
            throw new RuntimeException("기존 비밀번호 다른 요청");
        }

        // 새로운 비밀번호를 추가합니다.
        int result = passwordAdminDAO.insertPasswordAdmin
                (new PasswordAdminVO(Integer.parseInt(adminId), passwordNew));
        if (result == 1) {

            //암호 변경 성공 commit
            sqlSession.commit();
        }
    }

}