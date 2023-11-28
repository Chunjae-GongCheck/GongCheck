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

//    // 파일의 확장자 및 이미지 여부 확인
//    String ext = null;
//    String fileName = vo.
    // 파일 이름에서 확장자 추출

//    if (fileName != null){
//      ext = fileName.substring(fileName.lastIndexOf(".") + 1);
//    }
//    // 이미지 파일의 확장자들을 담고 있는 문자열 배열
//    String[] mimeStr = {"png","jpg","gif","jpeg"};
//    // 배열을 리스트로 변환
//    List<String> mimeList = Arrays.asList(mimeStr);
//    // 확장자를 통해 파일이 이미지인지 여부 확인
//    boolean isImage = false;
//    // 확장자가 이미지 확장자 리스트에 포함되어 있는지 확인
//    if (mimeList.contains(ext)){
//      isImage = true;
//    }

    req.setAttribute("vo" , vo);
//    req.setAttribute("isImage", isImage);
    req.getRequestDispatcher("/gck/PostView.do");

  }
}
