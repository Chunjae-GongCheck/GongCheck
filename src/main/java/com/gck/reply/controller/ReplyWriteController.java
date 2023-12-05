package com.gck.reply.controller;

import com.gck.post.controller.JSFunction;
import com.gck.post.model.PostDAO;
import com.gck.post.model.PostDAOImpl;
import com.gck.post.model.PostVO;
import com.gck.reply.model.ReplyDAO;
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
import java.util.List;

//value="/gck/ReplyWrite.do
@WebServlet(name="ReplyWriteController", value="/gck/ReplyWrite.do")
public class ReplyWriteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/reply/Reply.jsp").forward(req,resp);
        System.out.println("--------");
    }

    //댓글 작성
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("writeController_doPost_test");

        //로그인값, 게시판값 session 저장
        int memberIdx = (Integer) req.getSession().getAttribute("memberIdx");
        int postIdx = Integer.parseInt(req.getParameter("postIdx"));

        //테스트용
        System.out.println("postIdxAttr: " + postIdx);
        System.out.println("memberIdxAttr: " + memberIdx);

        //사용자 입력 값
        String replyContent = req.getParameter("replyContent");
        System.out.println(replyContent);

        ReplyVO replyVO = new ReplyVO();
        replyVO.setPostIdx(postIdx); //게시물 정보값
        replyVO.setReplyContent(replyContent); // 댓글 내용 값
        replyVO.setMemberIdx(memberIdx); //로그인값


        ReplyDAO dao = new ReplyService();
        int result = dao.createReplies(replyVO);

        if(result!=1){
            JSFunction.alertLocation(resp, "댓글 작성 실패했습니다.",
                    "/gck/ReplyWrite.do");
        }

        //글쓰기 성공

        resp.sendRedirect(req.getContextPath() + "/post/PostView.do");


//        RequestDispatcher dispatcher = req.getRequestDispatcher("/reply/Reply.jsp");
//        dispatcher.forward(req, resp);

//        System.out.println("replyservice_redirect_test");
//        resp.sendRedirect(req.getContextPath() + "/gck/PostView.do?postIdx=" + postIdxAttr);
    }

}
