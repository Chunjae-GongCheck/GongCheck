package com.gck.reply.controller;

import com.gck.reply.service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 댓글 등록
@WebServlet(name="ReplyWriteController", value="/gck/ReplyWrite.do")
public class ReplyWriteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static class ReplyServiceHelper{
        private static final ReplyService replyService = new ReplyService();
    }
    public static ReplyService getReplyService(){
        return ReplyServiceHelper.replyService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String postIdx = req.getParameter("postIdx");
        String memberIdx = req.getParameter("memberIdx");
        String replyContent = req.getParameter("replyContent");


        // 댓글 등록
        int result = getReplyService().createReplies(postIdx, memberIdx, replyContent);

        // 응답
        resp.getWriter().print(result);
    }

}
