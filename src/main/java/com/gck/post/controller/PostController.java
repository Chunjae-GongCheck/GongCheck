package com.gck.post.controller;

import com.gck.post.model.PostDAOImpl;
import com.gck.post.model.PostVO;
import com.gck.post.service.PopupViewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/gck/board/PopupView.do")
public class PostController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {

    PostDAOImpl postDaoImpl = new PostDAOImpl();
    Map<String, Object> map = new HashMap<>();

    System.out.println("popup & map 초기 값 넘어오는가????????" + postDaoImpl + map);
    req.setAttribute();
//    String currentView = req.getParameter()
  }
}
