package com.gck.reply.controller;

import com.gck.reply.service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ReplyEditController", value = "/gck/ReplyEdit.do")
public class ReplyEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static class ReplyServiceHelper {
        private static final ReplyService replyService = new ReplyService();
    }

    public static ReplyService getReplyService() {
        return ReplyEditController.ReplyServiceHelper.replyService;
    }

    // 댓글 수정하기
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 로그인 여부 체크 (세션에서 회원 정보를 가져옴)
        Integer memberIdx = (Integer) req.getSession().getAttribute("memberIdx");

        if (memberIdx == null) {
            //로그인 fail
            resp.getWriter().print("-1");
            return;
        }

        System.out.println("memberIdx값" + memberIdx);

        // replyIdx를 int로 변환
        int replyIdx = Integer.parseInt(req.getParameter("replyIdx"));
        String replyContent = req.getParameter("replyContent");
        String replyUpdateDate = req.getParameter("replyUpdateDate");

        // 수정일자가 null일 경우 현재 날짜로 설정
        if (replyUpdateDate == null || replyUpdateDate.isEmpty()) {
            replyUpdateDate = LocalDate.now().toString(); // 현재 날짜를 설정
        }

        // 댓글 수정
        int result = getReplyService().updateReplies(String.valueOf(memberIdx), String.valueOf(replyIdx), replyContent, replyUpdateDate);

        // 응답
        resp.getWriter().print(result);
    }
}