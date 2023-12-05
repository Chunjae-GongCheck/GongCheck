package com.gck.reply.controller;

import com.gck.reply.model.ReplyVO;
import com.gck.reply.service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ReplyView", value="/gck/ReplyViews.do")
public class ReplyController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReplyController(){
        super();
        System.out.println("ReplyController_test");
    }

    private static class ReplyServiceHelper{
        private static final ReplyService ReplyService = new ReplyService();
    }

//    public static ReplyService getRepliesByPost(){
//        return ReplyServiceHelper.ReplyService;
//    }

    // 댓글 [목록] 불러오기
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------");
        System.out.println("ReplyController_test");
        ReplyService replyService = new ReplyService();
        // 요청 파라미터에서 게시물 인덱스 추출
        String postIdx = req.getParameter("postIdx");

        System.out.println(postIdx);
        List<ReplyVO> list = replyService.getRepliesByPost(Integer.parseInt(postIdx));

        //테스트용
        for(ReplyVO replyVO: list){
            System.out.println(replyVO.getReplyContent());
        }

        //뷰 전달
        req.setAttribute("list",list);
        req.getRequestDispatcher("../post/PostView.jsp").forward(req,resp);
        System.out.println("--------");
    }


}
