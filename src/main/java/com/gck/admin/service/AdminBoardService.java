//package com.gck.admin.service;
//
//import com.gck.admin.model.*;
//import com.gck.factory.MyBatisFactory;
//import lombok.Data;
//import org.apache.ibatis.session.SqlSession;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Data
//public class AdminBoardService {
//
//    public List<AdminResultVO> selectAdminList() {
//        SqlSession sqlSession = MyBatisFactory.getSqlSession();
//        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
//        PasswordAdminDAO passwordAdminDAO = sqlSession.getMapper(PasswordAdminDAO.class);
//
//        List<AdminResultVO> adminResultVOS = new ArrayList<>();
//
//        List<AdminVO> adminVOS = adminDAO.selectAdminList();
//
//        for(AdminVO adminVo : adminVOS) {
//            List<PasswordAdminVO> passwordAdminVOS = passwordAdminDAO.selectPasswordAdminList(adminVo.getAdminIdx());
//
//            if (passwordAdminVOS != null && passwordAdminVOS.size() > 0)
//                adminResultVOS.add(new AdminResultVO(adminVo, passwordAdminVOS.get(0)));
//        }
//
//        return adminResultVOS;
//    }
//
//    public void deleteAdmin(String adminId) {
//        SqlSession sqlSession = MyBatisFactory.getSqlSession();
//        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
//
//        if (adminId == null || adminId.isEmpty()) {
//            throw new IllegalArgumentException("adminId is not null");
//        }
//
//        int result = adminDAO.deleteAdmin(adminId);
//        if (result == 1) {
//            //삭제 성공 시 commit
//            sqlSession.commit();
//        }
//    }
//
//    public AdminResultVO selectAdmin(String adminId) {
//
//        SqlSession sqlSession = MyBatisFactory.getSqlSession();
//        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
//        PasswordAdminDAO passwordAdminDAO = sqlSession.getMapper(PasswordAdminDAO.class);
//
//        AdminVO adminVo = adminDAO.selectAdmin(adminId);
//        PasswordAdminVO passwordAdminVO = passwordAdminDAO.selectPasswordAdminList(adminVo.getAdminIdx()).stream().findFirst().orElseGet(PasswordAdminVO::new);
//
//        return new AdminResultVO(adminVo, passwordAdminVO);
//
//    }
//
//    public void updateAdmin(String adminId, String passwordOrig, String passwordNew) {
//        SqlSession sqlSession = MyBatisFactory.getSqlSession();
//        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
//        PasswordAdminDAO passwordAdminDAO = sqlSession.getMapper(PasswordAdminDAO.class);
//
//
//        AdminVO adminVo = adminDAO.selectAdmin(adminId);
//        PasswordAdminVO passwordAdminVO = passwordAdminDAO.selectPasswordAdminList(adminVo.getAdminIdx()).stream().findFirst().orElseGet(PasswordAdminVO::new);
//
//        if (!Objects.equals(passwordAdminVO.getPasswordAdmin(), passwordOrig)) {
//            throw new RuntimeException("기존 비밀번호 다른 요청");
//        }
//
//        int result = passwordAdminDAO.insertPasswordAdmin(new PasswordAdminVO(Integer.parseInt(adminId), passwordNew));
//        if (result == 1) {
//            //암호 변경 성공 commit
//            sqlSession.commit();
//        }
//    }
//
//
////    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
////    public List<BoardVO> selectListPage(Map <String,Object> map) {
////        this.sqlSession = MyBatisFactory.getSqlSession();
////        mapper = this.sqlSession.getMapper(BoardDAO.class);
////
////        List<BoardVO> list = mapper.selectListPage(map);
////        System.out.println("test : " + list);
////        sqlSession.close();
////        return list;
////    }
////
////    public int selectCount (Map <String,Object> map) {
////        this.sqlSession =MyBatisFactory.getSqlSession();
////        mapper = this.sqlSession.getMapper(BoardDAO.class);
////
////
////        int result = mapper.selectCount(map);
////        sqlSession.close();
////        return result;
////    }
//
//
//}
