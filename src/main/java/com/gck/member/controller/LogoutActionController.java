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

// 로그아웃을 수행하는 컨트롤러
@WebServlet("/member/logout.do")
public class LogoutActionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 기본 생성자
    public LogoutActionController() {
        super();
    }

    // 서비스 객체 인스턴스 싱글톤
    private static class MemberServiceHelper {
        private static final MemberService memberService = new MemberService();
    }

    public static MemberService getMemberService() {
        return LogoutActionController.MemberServiceHelper.memberService;
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 객체 생성
        HttpSession session = req.getSession();

        // 이동할 url
        String url = req.getContextPath();

        // 세션에 로그인 정보가 없을 경우 메인 화면인 메인 화면으로 redirect
        if(session.getAttribute("memberIdx") == null){
            url += "/index.jsp";  // [@@@@@@@@@@] 메인 페이지로 수정해야 함. 메인 페이지로 가는 컨트롤러(board/main.do)로 연결해야 한다.
            resp.sendRedirect(url);
            System.out.println("here q");
            return;
        }

        // 세션에 로그인 정보가 있을 경우, 로그아웃
        session.invalidate(); //세션 삭제

        // redirectURL이 있는 경우 로그아웃 후에 redirectURL으로 이동하게 만들어 준다.
        String requestURI = req.getParameter("redirecturl");
        if(requestURI != null) {
            url += requestURI;
            System.out.println("here q");
        }else{  // 없을 경우, 메인 화면으로 이동한다. [@@@@@@@@@@]
            url += "/index.jsp";  // [@@@@@@@@@@] 메인 페이지로 수정해야 함. 메인 페이지로 가는 컨트롤러(board/main.do)로 연결해야 한다.
            System.out.println("here a");
        }

        resp.sendRedirect(url);
        return;
    }
}
