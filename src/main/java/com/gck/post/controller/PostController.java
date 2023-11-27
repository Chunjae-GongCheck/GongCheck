package com.gck.post.controller;

import com.gck.board.model.BoardVO;
import com.gck.board.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainView", value = "/gck/MainView.do")
public class PostController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // 서비스 생성 후 getter 만들어서 싱글톤 유지하면 편할 것 같습니다.

    private static class BoardServiceHelper {
        private static final BoardService boardService = new BoardService();
    }
    public static BoardService getBoardService(){
        return BoardServiceHelper.boardService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("test");
        // 게시물 목록 받기
        List<BoardVO> boardLists = getBoardService().selectListPage();

        // 전달할 데이터를 request 영역에 저장 후 list.jsp로 포워드
        req.setAttribute("boardLists", boardLists);
        req.getRequestDispatcher("/board/MainView.jsp").forward(req, resp);
    }
}
