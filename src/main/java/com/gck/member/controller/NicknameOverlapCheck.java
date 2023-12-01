package com.gck.member.controller;

import com.gck.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/overlapcheck.do")
public class NicknameOverlapCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NicknameOverlapCheck(){
        super();
    }

    private static class MemberServiceHelper {
        private static final MemberService memberService = new MemberService();
    }
    public static MemberService getMemberService(){
        return NicknameOverlapCheck.MemberServiceHelper.memberService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputValue = req.getParameter("inputValue");
        String type = req.getParameter("type");
        System.out.println("inputValue : " + inputValue);
        System.out.println("type : " + type);

        boolean exists = true;

        if(type.equals("0")){       // id
            System.out.println("id");
            exists = getMemberService().searchId(inputValue);
        }else if(type.equals("1")){ // 닉네임
            System.out.println("nick");
            exists = getMemberService().searchNickname(inputValue);
        }else if(type.equals("2")){ // 이메일
            System.out.println("email");
            exists = getMemberService().searchEmail(inputValue);
        }else{ }  // 오류

        System.out.println(exists);
        String result = "";

        if(exists){ // id 중복 O
            result = "1";
        }else{ // id 중복 X
            result = "0";
        }

        // 응답
        resp.getWriter().print(result);
        // out.print(result);
    }
}
