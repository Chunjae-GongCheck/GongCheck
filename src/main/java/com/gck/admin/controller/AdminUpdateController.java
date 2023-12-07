package com.gck.admin.controller;

import com.gck.admin.model.AdminResultVO;
import com.gck.admin.service.AdminBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// ** 회원정보 수정을 위한 컨트롤러입니다. **//

@WebServlet("/UpdateMemberServlet")
public class AdminUpdateController extends HttpServlet {

    private final AdminBoardService adminBoardService = new AdminBoardService();

    //GET 요청을 처리하는 메소드입니다.
    //회원정보를 조회하고, 조회 결과를 JSP 페이지로 전달합니다.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 요청으로부터 'idx' 파라미터 값을 가져옵니다.
        String adminId = request.getParameter("idx");

        try {

            // AdminBoardService를 사용하여 회원정보를 조회합니다.
            AdminResultVO adminResultVO = adminBoardService.selectAdmin(adminId);

            // 조회 결과인 ResultSet을 request의 속성으로 설정합니다.
            request.setAttribute("adminResultVo", adminResultVO);

            // AdminBoardDetail.jsp 페이지로 포워딩하여 결과를 해당 페이지에 전달합니다.
            request.getRequestDispatcher("/admin/AdminBoardDetail.jsp").forward(request, response);
        } catch (Exception e) {

            // 예외 발생 시 로그를 출력합니다.
            e.printStackTrace();
        }
    }


    //POST 요청을 처리하는 메소드입니다.
    //회원정보를 수정하고, 처리가 완료되면 회원 목록 페이지로 리디렉션합니다.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // 요청으로부터 'admin_idx', 'password_orig', 'password_new' 파라미터 값을 가져옵니다.
            String adminId = request.getParameter("admin_idx");
            String passwordOrig = request.getParameter("password_orig");
            String passwordNew = request.getParameter("password_new");

            // AdminBoardService를 사용하여 회원정보를 수정합니다.
            adminBoardService.updateAdmin(adminId, passwordOrig, passwordNew);

            // 처리가 완료되면 회원 목록 페이지로 리디렉션합니다.
            response.sendRedirect(request.getContextPath() + "/MemberListServlet");
        } catch (Exception e) {

            // 예외 발생 시 로그를 출력합니다.
            e.printStackTrace();
        }

    }
}