//package com.gck.board.controller;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet(name = "SearchModal" ,value = "/SearchModal.jsp")
//public class SearchController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//
//        String searchField = req.getParameter("searchField");
//        String searchWord = req.getParameter("searchWord");
//        System.out.println("searchWord =======> " + searchWord);
//        System.out.println("searchField =======> " + searchField);
//
//        req.setAttribute("searchWord", searchWord);
//        req.setAttribute("searchField", searchField);
//
//
//
////        String[] search = {searchField , searchWord};
//
//        session.setAttribute("searchWord",searchWord);
//        session.setAttribute("searchField",searchField);
//    }
//}
//
