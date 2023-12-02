package com.gck.reply.controller;

import com.gck.reply.model.ReplyVO;
import com.gck.reply.service.ReplyService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="ReplyWriteController", value="/reply/ReplyWrite.do")
public class ReplyWriteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ReplyWriteController(){
        super();
        System.out.println("ReplyWriteController_test(1)");
    }
    private static class ReplyServiceHelper{
        private static final ReplyService ReplyService = new ReplyService();
    }
    public static ReplyService createReplies(){
        return ReplyServiceHelper.ReplyService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("writeController_doGet_test");
        req.getRequestDispatcher("../reply/Reply.jsp").forward(req, resp);
    }

    //댓글 작성
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("writeController_doPost_test");
        ReplyService replyService = new ReplyService();

        //post_idx session에서 가져옴
        HttpSession session = req.getSession();

        int postIdx= (int) session.getAttribute("postIdx");
        int memberIdx = (int) session.getAttribute("memberIdx");

        //postIdx, memberIdx 가 있는 경우에만 댓글 작성 가능
        if(session.getAttribute("postIdx")!=null && session.getAttribute("memberIdx")!=null){
            String replyContent = req.getParameter("replyContent");


            //ReplyVO에 저장
            ReplyVO replyVO = new ReplyVO();
            replyVO.setPostIdx(postIdx); //게시물 정보값
            replyVO.setReplyContent(replyContent); // 댓글 내용 값
            replyVO.setMemberIdx(memberIdx); //로그인값

            //댓글 생성
            int result = replyService.createReplies(replyVO);

            if(result==1){
                System.out.println("댓글 정상적으로 작성");
            }else{
                System.out.println("댓글 작성 실패");
            }

        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("../reply/Reply.jsp");
        dispatcher.forward(req, resp);
    }

}
