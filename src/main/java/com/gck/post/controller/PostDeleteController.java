package com.gck.post.controller;

import com.gck.post.controller.FileUtil;
import com.gck.post.controller.JSFunction;
import com.gck.post.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

 @WebServlet("/gck/PostDelete.do")
public class PostDeleteController extends HttpServlet {

    // saveDirectory를 상수로 정의
    private static final String SAVE_DIRECTORY = "/Uploads";

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp)
             throws ServletException, IOException {
         {
             req.setAttribute("mode", req.getParameter("mode"));
             req.getRequestDispatcher("/post/PostDelete.jsp").forward(req, resp);
         }
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {        // 1. 로그인 여부 확인 (세션에 memberIdx가 있는지 확인)


        Integer memberIdx = (Integer) req.getSession().getAttribute("memberIdx");
        if (memberIdx == null) {
            // 로그인되지 않은 경우 처리
            JSFunction.alertLocation(resp, "로그인이 필요합니다.", "/GongCheck_war_exploded/member/loginform.do");
            return;
        }

        // 2. 게시물 번호 확인
        String postIdxStr = req.getParameter("postIdx");
        if (postIdxStr == null || postIdxStr.isEmpty()) {
            // 유효하지 않은 게시물 번호 처리
            JSFunction.alertLocation(resp, "유효하지 않은 게시물입니다.", "/gck/MainView.do");
            return;
        }

        int postIdx = Integer.parseInt(postIdxStr);

        // 3. 게시물 소유자 여부 확인 (작성자와 로그인한 회원이 동일한지 확인)
        PostDAO dao = new PostDAOImpl();
        PostVO postVO = dao.getPostByIdx(postIdx);

        if (postVO == null || postVO.getMemberIdx() != memberIdx) {
            // 권한이 없는 경우 처리
            JSFunction.alertLocation(resp, "게시물에 대한 권한이 없습니다.", "/gck/MainView.do");
            return;
        }


        // 4. 게시물 삭제 및 연관 파일 삭제
        PostImageDAO postImageDAO = new PostImageDAOImpl();
        ArrayList<PostImageVO> postImages = postImageDAO.getPostImagesByPostIdx(postIdx);


        for (PostImageVO postImage : postImages) {
            // 연관된 파일 삭제 (saveDirectory는 파일이 저장된 경로)

            File fileToDelete = new File(SAVE_DIRECTORY, postImage.getPostTImagePath());

            if (fileToDelete.exists()) {
                FileUtil.deleteFile(req, SAVE_DIRECTORY, postImage.getPostTImagePath());
            } else {
                System.out.println("파일이 존재하지 않습니다: " + fileToDelete.getAbsolutePath());
            }
        }

        // 게시물 삭제
        dao.deletePost(postIdx);

        // 5. 삭제 후 리다이렉트
        JSFunction.alertLocation(resp, "게시물이 삭제되었습니다.", "/GongCheck_war_exploded/gck/MainView.do");
    }
}
