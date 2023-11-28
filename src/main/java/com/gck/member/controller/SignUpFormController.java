package com.gck.member.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 회원가입 폼을 출력하는 컨트롤러
@WebServlet("/member/signupform.do")
public class SignUpFormController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 기본 생성자
    public SignUpFormController(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 이동할 주소
        String url = req.getContextPath();

        // 세션에 로그인 정보가 있을 경우
        if(req.getSession().getAttribute("memberIdx") != null){
            url += "/index_jy.jsp";  // [@@@@@@@@@@] 메인 페이지로 수정해야 함. 메인 페이지로 가는 컨트롤러(board/main.do)로 연결해야 한다.
            resp.sendRedirect(url);
            return;
        }

        url = "/member/signup.jsp";
        req.getRequestDispatcher(url).forward(req, resp);
    }
}
