package com.gck.post.controller;

import com.gck.post.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/post/PostWrite.do")

@MultipartConfig(
        maxFileSize = 1024 * 1024 * 1,
        maxRequestSize = 1024 * 1024 * 10
)
public class PostWriteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 로그인 확인
        HttpSession session = req.getSession();
        if(session.getAttribute("memberIdx") == null){
            JSFunction.alertLocation(resp, "먼저 로그인을 해주세요.",
                    req.getContextPath() + "/member/loginform.do");
            return;
        }
        req.getRequestDispatcher("/post/PostWrite.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 업로드 디렉터리의 물리적 경로 확인
        String saveDirectory = req.getServletContext().getRealPath("/Uploads");

        // 로그인 된 사용자 index
        int memberIdx = (Integer) req.getSession().getAttribute("memberIdx");

        // 사용자의 입력 값을 얻어옴
        String postTitle = req.getParameter("postTitle");
        String postContent = req.getParameter("postContent");

        // VO에 저장
        PostVO postVO = new PostVO();
        postVO.setPostTitle(postTitle);
        postVO.setPostContent(postContent);
        postVO.setBoardIdx(1); // 1: 공부 인증 게시판
        postVO.setMemberIdx(memberIdx);

        // DAO를 통해 DB에 게시 내용 저장
        PostDAO dao = new PostDAOImpl();
        Integer result = dao.insertPost(postVO);
        // 글 insert 실패
        if (result != 1) {
            JSFunction.alertLocation(resp, "글쓰기에 실패했습니다.",
                    "/post/PostWrite.do");
        }
        // 글쓰기 성공.

        // 이제부터 글에 연관(등록)된 여러 개의 파일을 저장하는 작업
        PostImageDAO postImageDAO = new PostImageDAOImpl();

        String originalFilename = FileUtil.uploadFile(req, saveDirectory);
        String savedFilename = FileUtil.renameFile(saveDirectory, originalFilename);

        PostImageVO postImageVO = new PostImageVO();

        postImageVO.setPostIdx(postVO.getPostIdx());
        postImageVO.setPostImagePath(originalFilename);
        postImageVO.setPostTImagePath(savedFilename);

        // PostImageVO를 DB에 저장.
        postImageDAO.insertPostImage(postImageVO);


        /*
        ArrayList<String> originalFilenameList = FileUtil.multipleFile(req, saveDirectory);
        for (String originalFilename : originalFilenameList) {
            String savedFilename = FileUtil.renameFile(saveDirectory, originalFilename);

            PostImageVO postImageVO = new PostImageVO();

            postImageVO.setPostIdx(postVO.getPostIdx());
            postImageVO.setPostImagePath(originalFilename);
            postImageVO.setPostTImagePath(savedFilename);

            // PostImageVO를 DB에 저장.
            postImageDAO.insertPostImage(postImageVO);
        }
        */

        resp.sendRedirect(req.getContextPath()+"/board/MainView.do");
    }
}
