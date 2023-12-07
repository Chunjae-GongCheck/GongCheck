package com.gck.admin.controller;

import com.gck.admin.service.AdminBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// ** 회원정보 삭제를 위한 컨트롤러입니다. **//

@WebServlet("/DeleteMemberServlet")
public class AdminDeleteController extends HttpServlet {

    private final AdminBoardService adminBoardService = new AdminBoardService();


    //POST 요청을 처리하는 메소드입니다.
    //회원정보를 삭제하고, 처리가 완료되면 회원 목록 (List)페이지로 리디렉션합니다.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 요청으로부터 'adminId' 파라미터 값을 가져옵니다.
        String adminId = request.getParameter("adminId");

        try {

            // AdminBoardService를 사용하여 회원정보를 삭제합니다.
            adminBoardService.deleteAdmin(adminId);
        } catch (Exception e) {

            // 예외 발생 시 로그를 출력합니다.
            e.printStackTrace();
        }

        // 처리가 완료되면 회원 목록 페이지로 리디렉션합니다.
        response.sendRedirect(request.getContextPath() + "/MemberListServlet");
    }
}