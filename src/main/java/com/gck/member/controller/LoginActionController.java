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

// 로그인을 수행하는 컨트롤러
@WebServlet("/member/login.do")
public class LoginActionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 기본 생성자
    public LoginActionController(){
        super();
    }

    // 서비스 객체 인스턴스 싱글톤
    private static class MemberServiceHelper {
        private static final MemberService memberService = new MemberService();
    }
    public static MemberService getMemberService(){
        return LoginActionController.MemberServiceHelper.memberService;
    }


    // 로그인
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 객체 생성
        HttpSession session = req.getSession();

        // 이동할 url
        String url = req.getContextPath();

        // 세션에 로그인 정보가 있을 경우 메인 화면인 메인 화면으로 redirect
        if(session.getAttribute("memberIdx") != null){
            url += "/index.jsp";
            resp.sendRedirect(url);
            return;
        }

        String memberId = req.getParameter("memberId");
        String passwordMember = req.getParameter("passwordMember");

        // id, pw에 맞는 memberIdx를 받아온다.
        int memberIdx = getMemberService().getMemberIdx(memberId, passwordMember);
        // memberIdx에 맞는 닉네임을 받아온다.
        String memberNickname = getMemberService().getNickname(memberIdx);

        // 로그인 시도
        if(memberIdx == -1){    // 로그인 실패
            req.setAttribute("message", "회원 정보가 존재하지 않습니다.");
            url = "/member/loginform.do";   // 다시 로그인 화면으로 이동한다.
        }else {  // 로그인 성공
            // session = req.getSession();  //세션 객체 생성
            session.setAttribute("memberIdx", memberIdx);   // session에 memberIdx 저장
            session.setAttribute("memberNickname", memberNickname);   // session에 memberNickname 저장
            session.setMaxInactiveInterval(60*60);   // 60*60초 동안 세션 유지, 60분 설정

            url += "/index.jsp";
            resp.sendRedirect(url);
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
