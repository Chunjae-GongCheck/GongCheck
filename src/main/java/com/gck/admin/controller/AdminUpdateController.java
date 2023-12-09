//package com.gck.admin.controller;
//
//import com.gck.admin.model.AdminResultVO;
//import com.gck.admin.service.AdminBoardService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//// *회원정보 수정* /
//
//@WebServlet("/UpdateMemberServlet")
//public class AdminUpdateController extends HttpServlet {
//
//    private final AdminBoardService adminBoardService = new AdminBoardService();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 요청으로부터 'idx' 파라미터 값을 가져옵니다.
//        String adminId = request.getParameter("idx");
//
//        try {
//            AdminResultVO adminResultVO = adminBoardService.selectAdmin(adminId);
//
//            // 조회 결과인 ResultSet을 request의 속성으로 설정합니다.
//            request.setAttribute("adminResultVo", adminResultVO);
//
//            // AdminBoardList.jsp 페이지로 포워딩, 결과를 해당 페이지에 전달합니다.
//            request.getRequestDispatcher("/admin/AdminBoardDetail.jsp").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        try {
//            // 요청으로부터 'idx' 파라미터 값을 가져옵니다.
//            String adminId = request.getParameter("admin_idx");
//            String passwordOrig = request.getParameter("password_orig");
//            String passwordNew = request.getParameter("password_new");
//
//            adminBoardService.updateAdmin(adminId, passwordOrig, passwordNew);
//
//            // AdminBoardList.jsp 페이지로 포워딩, 결과를 해당 페이지에 전달합니다.
//            response.sendRedirect(request.getContextPath()+"/MemberListServlet");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
