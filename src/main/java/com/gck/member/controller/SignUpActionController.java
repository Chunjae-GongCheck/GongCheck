package com.gck.member.controller;

import com.gck.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

// 회원가입을 진행하는 컨트롤러
@WebServlet("/member/signup.do")
public class SignUpActionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 기본 생성자
    public SignUpActionController() {
        super();
    }

    // 서비스 객체 인스턴스 싱글톤
    private static class MemberServiceHelper {
        private static final MemberService memberService = new MemberService();
    }
    public static MemberService getMemberService(){
        return SignUpActionController.MemberServiceHelper.memberService;
    }

    // 회원가입
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

        // 회원가입 폼에서 정보를 입력 받아 옴
        String memberId = req.getParameter("memberId");
        String passwordMember = req.getParameter("passwordMember");
        String memberNickname = req.getParameter("memberNickname");
        String memberEmail = req.getParameter("memberEmail");
        String memberZonecode = req.getParameter("memberZonecode");
        String memberAddress = req.getParameter("memberAddress");
        String memberAddressDetailed = req.getParameter("memberAddressDetailed");

        // 회원가입
        boolean result = getMemberService().signup(memberId, passwordMember, memberNickname, memberEmail, memberZonecode, memberAddress, memberAddressDetailed);

        // 회원가입 성공 여부에 따른 페이지 이동
        if(result){ // 회원가입 성공
            // 회원가입 축하 화면으로 리다이렉트
            url += "/member/signupsuccess.jsp";
            resp.sendRedirect(url);
            return;
        }else{      // 회원가입 실패
            // 다시 회원가입 폼 페이지로 리다이렉트
            url += "/member/signupform.do";
            // alert 출력
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            String script = "<script>"
                    + "    alert('" + "회원가입에 실패하였습니다." + "');"
                    + "    location.href='" + url + "';"
                    + "</script>";
            writer.print(script);
            writer.flush();
            writer.close();
        }
    }
}
