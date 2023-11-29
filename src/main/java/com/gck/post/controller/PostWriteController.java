package com.gck.post.controller;

import com.gck.post.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PostWrite", value = "/gck/PostWrite.do")

    @MultipartConfig(
            maxFileSize = 1024 * 1024 * 1,
            maxRequestSize = 1024 * 1024 * 10
    )
    public class PostWriteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String memberIdx = req.getParameter("memberIdx");

        PostDAO dao = new PostDAOImpl();

        PostVO vo = dao.selectView(memberIdx);

        req.setAttribute("vo", vo);
        req.getRequestDispatcher("../post/PostWrite.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1. 파일 업로드 처리 =============================
        // 업로드 디렉터리의 물리적 경로 확인

        String saveDirectory = req.getServletContext().getRealPath("/Uploads");
        Map<String, Object> map = new HashMap<>();

        // 로그인한 사람이 session에다가 memberIdx를 저장해 줘야함.
        // 현재는 테스트 용으로, 일단 session에 memberIdx값을 1로 저장.
        // 추후에 로그인 돼서 memberIdx가 sesion에 저장 됐을 경우, 현재 이 라인의 바로 아래 라인을 삭제해 주면 됨
        req.getSession().setAttribute("memberIdx", 1); // 얘!

        int memberIdx = (Integer) req.getSession().getAttribute("memberIdx");
        // 해당 변수를 map에 저장
        map.put("memberIdx",memberIdx);

        // 사용자의 입력 값을 얻어옴
        String postTitle = req.getParameter("postTitle");
        String postContent = req.getParameter("postContent");
        // 입력값 추가로 얻어오기
        String postImagePath = req.getParameter("postImagePath");
        String postTImagePath = req.getParameter("postTImagePath");
        // 해당 변수를 map에 저장
        map.put("postTitle",postTitle);
        map.put("postContent",postContent);
        map.put("postTImagePath",postTImagePath);
        map.put("postImagePath",postImagePath);



        // VO에 저장
        PostVO postVO = new PostVO();
        postVO.setPostTitle(postTitle);
        postVO.setPostContent(postContent);
//        postVO.setBoardIdx(1); // 현재는 보드 한 개밖에 없으니, 임시로 1번으로 고정시킴.
        postVO.setMemberIdx(memberIdx);
        postVO.setPostImagePath(postImagePath);
        postVO.setPostTImagePath(postTImagePath);

        // DAO를 통해 DB에 게시 내용 저장
        PostDAO dao = new PostDAOImpl();
        int result = dao.insertPost(postVO);

        // 성공 or 실패?
        if (result != 1) {  // 글쓰기 실패
            JSFunction.alertLocation(resp, "글쓰기에 실패했습니다.",
                    "../gck/PostWrite.do");
        }

        // 글쓰기 성공. 이제부터 글에 연관(등록)된 여러 개의 파일을 저장하는 작업
        PostDAO postDAO = new PostDAOImpl();

        ArrayList<String> originalFilenameList = FileUtil.multipleFile(req, saveDirectory);
        for (String originalFilename : originalFilenameList) {
            String savedFilename = FileUtil.renameFile(saveDirectory, originalFilename);
            postVO.setPostIdx(postVO.getPostIdx());
            postVO.setPostImagePath(originalFilename);
            postVO.setPostTImagePath(savedFilename);

            // PostVO를 DB에 저장.
            postDAO.selectPostWithImage(map);
            postDAO.insertPostImage(postVO);
        }
        req.setAttribute("map",map);
        req.setAttribute("originalFilenameList",originalFilenameList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("../post/PostWrite.jsp");
        dispatcher.forward(req, resp);

        System.out.println("새로운 Post 등록 성공!");
    }

}
