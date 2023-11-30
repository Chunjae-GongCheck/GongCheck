package com.gck.member.controller;

import com.gck.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

// 아이디 중복 확인
@WebServlet("/member/idoverlapcheck.do")
public class IdOverlapCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IdOverlapCheck(){
        super();
    }

    private static class MemberServiceHelper {
        private static final MemberService memberService = new MemberService();
    }
    public static MemberService getMemberService(){
        return IdOverlapCheck.MemberServiceHelper.memberService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberId = req.getParameter("memberId");
        System.out.println("IdOverlapCheck" + memberId);

        boolean exists = getMemberService().searchId(memberId);

        String result = "";

        if(exists){ // id 중복 O
            result = "1";
            //out.print(result);
            resp.getWriter().print(result);
        }else{ // id 중복 X
            result = "0";
            //out.print(result);
            resp.getWriter().print(result);
        }
    }
}
