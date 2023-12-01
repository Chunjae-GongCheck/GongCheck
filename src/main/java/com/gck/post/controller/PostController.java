package com.gck.post.controller;

import com.gck.post.model.PostDAOImpl;
import com.gck.post.model.PostImageDAOImpl;
import com.gck.post.model.PostImageVO;
import com.gck.post.model.PostVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PostView", value = "/gck/PostView.do")
public class PostController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {


    // 생성자
    PostDAOImpl postDaoImpl = new PostDAOImpl();
    PostImageDAOImpl postImageDAOImpl = new PostImageDAOImpl();
    HttpSession session = req.getSession();

    // 세션에 저장되어있는 값 가져오기
    Map<String, Object> sessionMap = (Map<String, Object>) session.getAttribute("map");
    List<String> sessionPostImageVOList = (List<String>) session.getAttribute("postImageVOList");
    List<String> sessionBoardLists = (List<String>) session.getAttribute("boardLists");
    // 값이 잘 들어가는지 확인;
    System.out.println("map ======> "+sessionMap);
    System.out.println("postImageVOList ======> "+sessionPostImageVOList);
    System.out.println("boardLists ======> "+sessionBoardLists);

    // 요청 파라미터에서 게시물 인덱스 추출
    String postIdx = req.getParameter("postIdx");
    // 조회수 증가 메서드 호출
    postDaoImpl.updateVisitCount(postIdx);
    // 게시물 조회 메서드 호출
    PostVO vo = postDaoImpl.selectView(postIdx);
    // 게시물 안에 사진들을 가져옴
    ArrayList<PostImageVO> piVO = postImageDAOImpl.getPostImagesByPostIdx((int)Integer.parseInt(postIdx));

    HashMap<Integer, String> map = new HashMap<>();
    map.put(1, "/Uploads/");
    map.put(2, "이미지 경로");
    map.put(3, "이미지 경로");
    req.setAttribute("imagesPath", map);

    System.out.println("해쉬맵 이미지 경로 : ====> "+map);
    System.out.println("piVO =====> " + piVO);



    // 게시물의 줄 바꿈 처리 ( 개행 문자를 <br/>로 변경 )
    vo.setPostContent(vo.getPostContent().replaceAll("\r\n" ,"<br />"));
    String result = null;
//     이미지 호출 메서드
//    if (postIdx == postImageIdx){
//      result = postTImagePath;
//      System.out.println("해당 게시물이 맞습니다.");
//    } else {
//      System.out.println("해당 게시물이 아닙니다.");
//    }



//
//    for (String postImageIdx : sessionPostImageVOList){
//      String postImageIdx = sessionPostImageVOList.getPostImageIdx();
//      System.out.println("세션리스트에서 인덱스 추출 ======> " +postImageIdx);
//    }



    req.setAttribute("piVO",piVO);
    req.setAttribute("vo" , vo);
    req.setAttribute("result", result);
    req.getRequestDispatcher("/post/PostView.jsp").forward(req, resp);

  }


}
