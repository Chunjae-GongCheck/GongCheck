package com.gck.reply.controller;

import com.gck.reply.model.ReplyDAO;
import com.gck.reply.model.ReplyVO;
import com.gck.reply.service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/gck/ReplyEdit.do")
public class ReplyEditController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static class ReplyServiceHelper{
        private static final ReplyService replyService = new ReplyService();
    }

    //댓글 수정하기
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        // 수정할 댓글 번호를 받아옴
        String replyIdx = req.getParameter("replyIdx");
        System.out.println("삭제할 번호 replyIdx"+replyIdx);

        // postIdx가 null 또는 빈 문자열인 경우 -1로 설정
        if (replyIdx == null || replyIdx.isEmpty()) {
            replyIdx = "-1";
        }

        ReplyDAO dao = new ReplyService();
        //ArrayList<ReplyVO> replyVO =  dao.getReplies(Integer.parseInt(replyIdx));

        int memberIdx = (Integer) req.getSession().getAttribute("memberIdx");

        req.getRequestDispatcher("/reply/Reply.jsp").forward(req,resp);
         */
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int memberIdx = (Integer) req.getSession().getAttribute("memberIdx");

        //사용자 입력 값 가져옴
        String replyContent = req.getParameter("replyContent");
        String replyIdx = req.getParameter("replyIdx");

        if(replyIdx==null||replyIdx.isEmpty()){

        }

    }

}
