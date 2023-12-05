package com.gck.admin.controller;

import com.gck.admin.service.AdminBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// *회원정보 삭제* /

@WebServlet("/DeleteMemberServlet")
public class AdminDeleteController extends HttpServlet {

    private final AdminBoardService adminBoardService = new AdminBoardService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청으로부터 'idx' 파라미터 값을 가져옵니다.
        String adminId = request.getParameter("adminId");

        try {
            adminBoardService.deleteAdmin(adminId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 처리가 완료되면 회원 목록 페이지로 리디렉션합니다.
        response.sendRedirect(request.getContextPath() + "/MemberListServlet");
    }
}
