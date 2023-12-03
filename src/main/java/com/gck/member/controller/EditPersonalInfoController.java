package com.gck.member.controller;

import com.gck.member.model.PasswordMemberVO;
import com.gck.member.service.MemberService;
import com.gck.member.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

// 회원 정보 수정을 수행하는 컨트롤러
@WebServlet("/member/edit.do")
public class EditPersonalInfoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 기본 생성자
    public EditPersonalInfoController(){
        super();
    }

    // 서비스 객체 인스턴스 싱글톤
    private static class MemberServiceHelper {
        private static final MemberService memberService = new MemberService();
    }
    public static MemberService getMemberService(){
        return EditPersonalInfoController.MemberServiceHelper.memberService;
    }

    // 회원 정보 수정 페이지 출력
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 객체 생성
        HttpSession session = req.getSession();

        // 이동할 url
        String url = req.getContextPath();

        // 로그인 되어 있는 회원 idx
        String memberIdx = (String)session.getAttribute("memberIdx");

        // 세션에 로그인 정보가 없을 경우 메인 화면으로 redirect
        if(memberIdx == null){
            url += "/index.jsp";  // [@@@@@@@@@@] 메인 페이지로 수정해야 함. 메인 페이지로 가는 컨트롤러(board/main.do)로 연결해야 한다.
            resp.sendRedirect(url);
            return;
        }

        // 회원 정보 가져옴
        MemberVO memberVo = getMemberService().getMember(memberIdx);

        // 실패
        if(memberVo == null){
            // 메인 화면으로 이동 [@@@@@@@@@@]
            url += "/index.jsp";

            // alert 출력
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            String script = "<script>"
                    + "    alert('" + "회원 정보 수정을 하실 수 없습니다." + "');"
                    + "    location.href='" + url + "';"
                    + "</script>";
            writer.print(script);
            writer.flush();
            writer.close();
            return;
        }

        // 회원 정보를 페이지에 출력
        req.setAttribute("memberVO", memberVo);

        url += "/member/edit.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    // 회원 정보 수정 기능 수행
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 객체 생성
        HttpSession session = req.getSession();

        // 이동할 url
        String url = req.getContextPath();

        // 세션에 로그인 정보가 없을 경우 메인 화면으로 redirect
        if(session.getAttribute("memberIdx") == null){
            url += "/index.jsp";  // [@@@@@@@@@@] 메인 페이지로 수정해야 함. 메인 페이지로 가는 컨트롤러(board/main.do)로 연결해야 한다.
            resp.sendRedirect(url);
            return;
        }


    }
}
