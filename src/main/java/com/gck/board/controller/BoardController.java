package com.gck.board.controller;

import com.gck.board.model.BoardDAO;
import com.gck.board.service.BoardService;
import com.gck.post.model.PostVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/gck/board/MainView.do")
public class BoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("testBoard");
        String url = "/board/MainView.jsp";



        // pageNum = req.getAttribute("boardPageNum");
        // 매퍼로 쿼리문 호출해서 실행.
        //

//        ArrayList<PostVO> boardList = BoardService.
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);

    }
}
