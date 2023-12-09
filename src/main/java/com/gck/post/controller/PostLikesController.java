package com.gck.post.controller;

import com.gck.post.service.PostService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 게시물 좋아요
@WebServlet("/post/updatelikes.do")
public class PostLikesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 기본 생성자
    public PostLikesController() {super();}

    private static class PostServiceHelper {
        private static final PostService postService = new PostService();
    }
    public static PostService getPostService(){
        return PostLikesController.PostServiceHelper.postService;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postIdx = req.getParameter("postIdx");
        String memberIdx = req.getParameter("memberIdx");

        // 과거 추천 여부
        int exists = -1;
        exists = getPostService().getPostLikes(postIdx, memberIdx);

        String result = "";
        JSONObject obj = new JSONObject();
        // 좋아요 존재 여부 확인
        if(exists == 1){
            // 추천한 적 있음
            // 추천 취소
            obj = getPostService().deleteLikes(postIdx, memberIdx);
        }else if(exists == 0){
            // 추천한 적 없음
            // 추천하기
            obj = getPostService().insertLikes(postIdx, memberIdx);
        }else{
            // 좋아요 여부 확인 오류
        }

        // 문자 인코딩 utf-8 설정 (한글 깨짐 방지)
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        // 응답
        resp.getWriter().print(obj);
    }
}
