package com.gck.admin.controller;

import com.gck.admin.model.AdminResultVO;
import com.gck.admin.service.AdminBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//*회원정보 조회* //

@WebServlet("/MemberListServlet")
public class AdminBoardListController extends HttpServlet { 

    private final AdminBoardService adminBoardService = new AdminBoardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<AdminResultVO> adminResultVOS = adminBoardService.selectAdminList();

            // 조회 결과인 ResultSet을 request의 속성으로 설정합니다.
            request.setAttribute("adminResultVos", adminResultVOS);

            // AdminBoardList.jsp 페이지로 포워딩, 결과를 해당 페이지에 전달합니다.
            request.getRequestDispatcher("/admin/AdminBoardList.jsp").forward(request, response);
        } catch (Exception e) {
            // 예외 발생 시 로그 출력합니다.
            e.printStackTrace();
        }
    }
}
