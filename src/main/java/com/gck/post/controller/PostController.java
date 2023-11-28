package com.gck.post.controller;

import com.gck.post.model.PostDAOImpl;
import com.gck.post.model.PostVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PostView", value = "/gck/PostView.do")
public class PostController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {



    PostDAOImpl postDaoImpl = new PostDAOImpl();
    String postIdx = req.getParameter("postIdx");
    postDaoImpl.updateVisitCount(postIdx);
    PostVO vo = postDaoImpl.selectView(postIdx);
    vo.setPostContent(vo.getPostContent().replaceAll("\r\n" ,"<br />"));

    req.setAttribute("vo" , vo);
    req.getRequestDispatcher("/gck/PostView.do");

  }


}
