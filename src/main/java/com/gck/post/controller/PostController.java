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


    // 생성자
    PostDAOImpl postDaoImpl = new PostDAOImpl();
    // 요청 파라미터에서 게시물 인덱스 추출
    String postIdx = req.getParameter("postIdx");
    // 조회수 증가 메서드 호출
    postDaoImpl.updateVisitCount(postIdx);
    // 게시물 조회 메서드 호출
    PostVO vo = postDaoImpl.selectView(postIdx);
    // 게시물의 줄 바꿈 처리 ( 개행 문자를 <br/>로 변경 )
    vo.setPostContent(vo.getPostContent().replaceAll("\r\n" ,"<br />"));

    // 이미지 경로 받아오기


    req.setAttribute("vo" , vo);
    req.getRequestDispatcher("/post/PostView.jsp").forward(req, resp);

  }


}
