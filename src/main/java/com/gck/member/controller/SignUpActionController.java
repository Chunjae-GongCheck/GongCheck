package com.gck.member.controller;

import com.gck.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 회원가입을 진행하는 컨트롤러
@WebServlet("/member/signup.do")
public class SignUpActionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

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

    }
}
