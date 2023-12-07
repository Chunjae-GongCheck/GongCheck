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

// ** 회원정보 조회를 위한 컨트롤러입니다. **//

@WebServlet("/MemberListServlet")
public class AdminBoardListController extends HttpServlet {

    private final AdminBoardService adminBoardService = new AdminBoardService();


    //GET 요청을 처리하는 메소드입니다.
    //회원정보를 조회하고, 조회 결과를 JSP 페이지로 전달합니다.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // AdminBoardService를 사용하여 회원정보를 조회합니다.
            List<AdminResultVO> adminResultVOS = adminBoardService.selectAdminList();

            // 조회 결과인 ResultSet을 request의 속성으로 설정합니다.
            request.setAttribute("adminResultVos", adminResultVOS);

            // AdminBoardList.jsp 페이지로 포워딩하여 결과를 해당 페이지에 전달합니다.
            request.getRequestDispatcher("/admin/AdminBoardList.jsp").forward(request, response);
        } catch (Exception e) {
            // 예외 발생 시 로그를 출력합니다.
            e.printStackTrace();
        }
    }
}