package com.gck.reply.controller;

import com.gck.reply.service.ReplyService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="ReplyView", value="/gck/ReplyViews.do")
public class ReplyController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReplyController(){
        super();
        System.out.println("ReplyController_test");
    }

    private static class ReplyServiceHelper{
        private static final ReplyService replyService = new ReplyService();
    }
    public static ReplyService getReplyService(){
        return ReplyController.ReplyServiceHelper.replyService;
    }


    // 댓글 [목록] 불러오기
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postIdx = Integer.parseInt(req.getParameter("postIdx"));

        JSONObject obj = getReplyService().getRepliesJSON(postIdx);

        // 문자 인코딩 utf-8 설정 (한글 깨짐 방지)
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        // 응답
        resp.getWriter().print(obj);
    }


}