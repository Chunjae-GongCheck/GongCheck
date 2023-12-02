package com.gck.member.controller;

import com.gck.board.service.BoardService;
import com.gck.member.service.MemberService;
import com.gck.post.controller.PostController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/members/login.do")
public class LogInController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 기본 생성자
    public LogInController(){
        super();
        System.out.println("test2");
    }

    // 서비스 객체 인스턴스 싱글톤
    private static class MemberServiceHelper {
        private static final MemberService memberService = new MemberService();
    }
    public static MemberService getMemberService(){
        return MemberServiceHelper.memberService;
    }


    // get으로 들어올 경우 페이지 표시
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test3");
        HttpSession session = req.getSession();
        // login.jsp로 기본적으로 이동한다.
        String url = "login.jsp";    // [@@@@@@@@@@] 이동할 페이지

        // 세션에 로그인 정보가 있을 경우 메인 화면인 main.jsp로 이동한다.
        if(session.getAttribute("memberIdx") != null){
            url = "/index.jsp";  // [@@@@@@@@@@] 메인 페이지로 수정해야 함. 메인 페이지로 가는 컨트롤러(board/main.do)로 연결해야 한다.
        }

        // redirectURL이 있는 경우 로그인 후에 redirectURL으로 이동하게 만들어 준다.
        String requestURI = req.getParameter("redirectURL");
        if(requestURI != null) {
            req.setAttribute("redirectURL", requestURI);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }


    // 로그인
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test1");
        String memberId = req.getParameter("memberId");
        String passwordMember = req.getParameter("passwordMember");
        System.out.println(memberId+", "+passwordMember);
        String url = "";
        // id, pw에 맞는 memberidx를 받아온다.
        int memberIdx = getMemberService().getMemberIdx(memberId, passwordMember);

        // 해당하는 회원 정보가 없다.
        if(memberIdx == -1){
            req.setAttribute("message", "회원 정보가 존재하지 않습니다.");
            url = "/member/login.do";   // 다시 로그인 화면으로 이동한다.
        }else {  // 로그인 성공
            HttpSession session = req.getSession();  //세션 객체 생성
            session.setAttribute("memberIdx", memberIdx);

            System.out.println(req.getContextPath() + "   **    " + req.getRequestURI());
            //url = "../index.jsp"; // [@@@@@@@@@@] 메인화면으로 이동한다.
            // 메인화면으로 redirect 한다.
            url = "/index.jsp";

            // redirectURL이 있는 경우 로그인 후에 redirectURL(로그인을 호출한 페이지)으로 이동하게 만들어 준다.
            // [@@@@@@@@@@] 나중에 확인 필요
            String requestURI = req.getParameter("redirectURL");
            if(requestURI != null) {
                url = requestURI;
            }
        }

        System.out.println("url: " + url);
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
