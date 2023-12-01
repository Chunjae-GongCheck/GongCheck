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

@WebServlet("/gck/PostEdit.do")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 1,
        maxRequestSize = 1024 * 1024 * 10
)

    public class PostEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 수정할 게시물의 일련번호를 받아옴
        String postIdx = req.getParameter("postIdx");
        System.out.println("postIdx in servlet (doGet): " + postIdx);

        // postIdx가 null 또는 빈 문자열인 경우 -1로 설정
        if (postIdx == null || postIdx.isEmpty()) {
            postIdx = "-1";
        }
        // 기존 게시물 내용을 VO객체의 req 영역에 저장하고난 후 포워드
        PostDAO dao = new PostDAOImpl();
        PostVO postVO = dao.selectView(postIdx);
        req.setAttribute("postVO", postVO);
        req.getRequestDispatcher("/post/PostEdit.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String saveDirectory = req.getServletContext().getRealPath("/Uploads");

        // 파일 업로드
        ArrayList<String> originalFilenameList;
        try {
            originalFilenameList = FileUtil.multipleFile(req, saveDirectory);
        } catch (Exception e) {
            JSFunction.alertBack(resp, "파일 업로드 오류입니다.");
            return;
        }

        // 로그인한 사람이 session에다가 memberIdx를 저장해 줘야함.
        // 현재는 테스트 용으로, 일단 session에 memberIdx값을 1로 저장.
        // 추후에 로그인 돼서 memberIdx가 sesion에 저장 됐을 경우, 현재 이 라인의 바로 아래 라인을 삭제해 주면 됨
        req.getSession().setAttribute("memberIdx", 1); // 얘!

        int memberIdx = (Integer) req.getSession().getAttribute("memberIdx");


        // 사용자의 입력 값을 얻어옴
        String postTitle = req.getParameter("postTitle");
        String postContent = req.getParameter("postContent");
        String preOriginalFile = req.getParameter("preOriginalFile");
        String preSavedFile = req.getParameter("preSavedFile");
        String postIdx = req.getParameter("postIdx");

        // postIdx가 null이거나 비어있을 때의 처리
        if (postIdx == null || postIdx.isEmpty()) {
            // 예외 처리 또는 기본값 설정 등을 수행할 수 있습니다.
            // 여기에서는 기본값으로 -1을 설정하는 경우:
            postIdx = "-1";
        }



        HttpSession session = req.getSession();

        // VO에 저장
        PostDAO postDAO = new PostDAOImpl();
        PostVO postVO = new PostVO();
        postVO.setPostTitle(postTitle);
        postVO.setPostContent(postContent);
        postVO.setBoardIdx(1); // 현재는 보드 한 개밖에 없으니, 임시로 1번으로 고정시킴.
        postVO.setMemberIdx(memberIdx);
        postVO.setPostIdx(Integer.parseInt(postIdx));



        if (postIdx != null && !postIdx.isEmpty()) {
            postVO.setPostIdx(Integer.parseInt(postIdx));
        } else {
            // 예외 처리 또는 기본값 설정 등을 수행할 수 있습니다.
            // 예를 들어, 기본값으로 -1을 설정하는 경우:
            postVO.setPostIdx(-1);
        }

        int updateResult = postDAO.updatePost(postVO);

        // 파일 업로드를 처리하는 부분
        PostImageDAO postImageDAO = new PostImageDAOImpl();
        for (String originalFilename : originalFilenameList) {
            String savedFilename = FileUtil.renameFile(saveDirectory, originalFilename);

            PostImageVO postImageVO = new PostImageVO();
            postImageVO.setPostIdx(postVO.getPostIdx());

            if (originalFilename != null && !originalFilename.equals("")) {
                String savedFileName = FileUtil.renameFile(saveDirectory, originalFilename);

                postImageVO.setPostImagePath(originalFilename);  // 원래 파일 이름
                postImageVO.setPostTImagePath(savedFileName);

                // 기존 파일 삭제
                FileUtil.deleteFile(req, "/Uploads", preSavedFile);
            }
        else {
            // 첨부 파일이 없으면 기존 이름 유지
            postImageVO.setPostImagePath(preOriginalFile);
            postImageVO.setPostTImagePath(preSavedFile);

        }
            // PostImageVO를 DB에 저장.
            postImageDAO.updatePostImage(postImageVO);
        }
        System.out.println("Post 수정 성공!");



    }
}
