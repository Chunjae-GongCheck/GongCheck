package com.gck.member.controller;

import com.gck.member.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 로그인 화면을 출력하는 컨트롤러
@WebServlet("/member/loginform.do")
public class LogInFormController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 기본 생성자
    public LogInFormController(){
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String url = "";

        // 세션에 로그인 정보가 있을 경우 메인 화면인 메인 화면으로 redirect
        if(session.getAttribute("memberIdx") != null){
            url = req.getContextPath() + "/index.jsp";
            resp.sendRedirect(url);
            return;
        }

        url = "/member/login.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
