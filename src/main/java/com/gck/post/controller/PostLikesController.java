package com.gck.post.controller;

import com.gck.post.service.PostService;

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
        System.out.println("postIdx : " + postIdx);
        System.out.println("memberIdx : " + memberIdx);

        int exists = -1;

        System.out.println("id");
        // 과거 추천 여부
        exists = getPostService().getPostLikes(postIdx, memberIdx);


        System.out.println(exists);
        String result = "";

        // 좋아요 존재 여부 확인
        if(exists == 1){
            // 추천한 적 있음
            // 추천 취소
            if(!getPostService().deleteLikes(postIdx, memberIdx)){
                result = "-1";  // 추천 취소 오류
            }else {
                result = "1";
            }
        }else if(exists == 0){
            // 추천한 적 없음
            // 추천하기
            if(!getPostService().insertLikes(postIdx, memberIdx)) {
                result = "-1";  // 추천하기 오류
            }else{
                result = "0";
            }
        }else{
            // 좋아요 여부 확인 오류
            result = "-1";
        }

        // 응답
        resp.getWriter().print(result);
    }
}
