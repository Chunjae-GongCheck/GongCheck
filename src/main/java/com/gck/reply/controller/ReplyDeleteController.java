package com.gck.reply.controller;

import com.gck.reply.service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReplyDeleteController", value = "/gck/ReplyDelete.do")
public class ReplyDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static class ReplyServiceHelper {
        private static final ReplyService replyService = new ReplyService();
    }

    public static ReplyService getReplyService() {
        return ReplyServiceHelper.replyService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 로그인 여부
        Integer memberIdxAttr = (Integer) req.getSession().getAttribute("memberIdx");
        if (memberIdxAttr == null) {
            // 로그인 실패
            resp.getWriter().print("-1");
            return;
        }

        // 댓글 삭제를 요청하는 사용자
        int memberIdx = memberIdxAttr;
        // 삭제할 댓글 인덱스
        int replyIdx = Integer.parseInt(req.getParameter("replyIdx"));
        // 댓글 삭제
        int result = getReplyService().deleteReplies(memberIdx, replyIdx);

        // 응답
        resp.getWriter().print(result);
    }
}