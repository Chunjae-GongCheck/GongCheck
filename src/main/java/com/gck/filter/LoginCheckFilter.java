package com.gck.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

// 글 작성하기, 글 수정하기, 글 삭제하기
// 댓글 작성하기, 댓글 수정하기, 댓글 삭제하기
// 전에 필터를 통해 로그인 정보를 확인한다.
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/member/login.jsp"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        try {
            System.out.println("인증 체크 필터 시작{}" + requestURI);
            System.out.println("인증 체크 로직 실행{}"+ requestURI);
            HttpSession session = httpRequest.getSession(false);

            // 로그인된 세션 정보가 없다 || 세션의 memberId가 없다
            if (session == null || session.getAttribute("memberIdx") == null) {
                System.out.println("미인증 사용자 요청 {}"+ requestURI);
                // 로그인으로 redirect
                // 로그인 컨트롤러에서 redirectURL이 있으면 로그인 성공 후 redirectURL로 이동하게 된다.
                httpResponse.sendRedirect("../member/login.do?redirectURL="+ requestURI);
                System.out.println("request uri" + requestURI);
                return;
            }

            // controller로 넘어간다.
            System.out.println("durl ");
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("인증 체크 필터 종료{}"+ requestURI);
        }
    }
}