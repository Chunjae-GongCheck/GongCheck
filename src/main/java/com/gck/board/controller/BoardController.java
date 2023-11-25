package com.gck.board.controller;

import com.gck.board.model.BoardDAO;
import com.gck.board.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/gck/board/MainView.do")
public class BoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        BoardService brdService = new BoardService();
        Map<String, Object> map = new HashMap<>();

        


    }
}
