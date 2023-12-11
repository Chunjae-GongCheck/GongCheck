package com.gck.member.controller;

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
import java.util.HashMap;

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
        Object memberIdx = session.getAttribute("memberIdx");

        // 세션에 로그인 정보가 없을 경우 메인 화면으로 redirect
        if(memberIdx == null){
            url += "/index.jsp";
            resp.sendRedirect(url);
            return;
        }

        // 회원 정보 가져옴
        MemberVO memberVo = getMemberService().getMember(memberIdx.toString());

        // 실패
        if(memberVo == null){
            // 메인 화면으로 이동
            url += "/index.jsp";

            // alert 출력
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            String script = "<script>"
                    + "    alert('" + "회원 정보 수정을 하실 수 없습니다. 회원 조회가 불가능합니다." + "');"
                    + "    location.href='" + url + "';"
                    + "</script>";
            writer.print(script);
            writer.flush();
            writer.close();
            return;
        }

        // 회원 정보를 페이지에 출력
        req.setAttribute("memberVo", memberVo);

        url = "/member/edit.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    // 회원정보 수정 기능 수행
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 객체 생성
        HttpSession session = req.getSession();

        // 이동할 url
        String url = req.getContextPath();

        // 로그인 되어 있는 회원 idx
        Object memberIdx = session.getAttribute("memberIdx");

        // 세션에 로그인 정보가 없을 경우 메인 화면으로 redirect
        if(memberIdx == null){
            url += "/index.jsp";
            resp.sendRedirect(url);
            return;
        }

        // 회원정보 수정 폼에서 정보를 받아와 hashmap에 넣는다.
        HashMap<String, String> map = new HashMap<>();
        map.put("memberIdx", memberIdx.toString());
        map.put("memberNickname", req.getParameter("memberNickname"));
        map.put("memberEmail", req.getParameter("memberEmail"));
        map.put("memberZonecode", req.getParameter("memberZonecode"));
        map.put("memberAddress", req.getParameter("memberAddress"));
        map.put("memberAddressDetailed", req.getParameter("memberAddressDetailed"));


        // 회원정보 수정
        boolean result = getMemberService().updateMember(map);

        url += "/member/edit.do";
        // 회원정보 수정 성공 여부에 따른 메세지
        String msg = "";

        if(result){ // 성공
            msg = "회원정보를 수정하였습니다.";
            // 세션에 변경된 닉네임 update
            session.removeAttribute("memberNickname");
            session.setAttribute("memberNickname", req.getParameter("memberNickname"));
        }else{      // 실패
            msg = "회원정보 수정에 실패하였습니다.";
        }

        // alert 출력
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String script = "<script>"
                + "    alert('" + msg + "');"
                + "    location.href='" + url + "';"
                + "</script>";
        writer.print(script);
        writer.flush();
        writer.close();
    }
}
