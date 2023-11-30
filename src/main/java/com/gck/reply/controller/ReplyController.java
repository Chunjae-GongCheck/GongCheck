package com.gck.reply.controller;

import com.gck.reply.service.ReplyService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/replies")
public class ReplyController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static class ReplyServiceHelper{
        private static final ReplyService ReplyService = new ReplyService();
    }

    public static ReplyService getRepliesByPost(){
        return ReplyServiceHelper.ReplyService;
    }
    //   @GetMapping("/replies/list/{postIdx}")
    //  public String getRepliesByPost(@PathVariable("postIdx") int postIdx, Model model) {
    //      List<ReplyVO> replies = replyService.getRepliesByPost(postIdx);
    //     model.addAttribute("replies", replies);
    //     return "Reply";
    //  }
}
