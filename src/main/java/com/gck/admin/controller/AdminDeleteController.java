package com.gck.admin.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// *회원정보 삭제* /

@WebServlet("/DeleteMemberServlet")
public class AdminDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET 요청이 오면 doPost 메서드로 처리를 넘깁니다.
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청으로부터 'idx' 파라미터 값을 가져옵니다.
        String idx = request.getParameter("idx");

        try {
            // MySQL JDBC 드라이버를 로드합니다.
            Class.forName("com.mysql.jdbc.Driver");

            // 데이터베이스 URL 설정
            String DB_URL = "jdbc:mysql://localhost:3306/member";

            // 데이터베이스 연결
            Connection con = DriverManager.getConnection(DB_URL, "root", "12345");

            // SQL 쿼리문을 작성합니다. 특정 'idx'를 가진 회원을 삭제합니다.
            String sql = "DELETE FROM member WHERE idx=?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // 쿼리문의 첫 번째 매개변수(1)에 'idx' 값을 설정합니다.
            pstmt.setInt(1, Integer.parseInt(idx));

            // 쿼리를 실행하여 데이터를 삭제합니다.
            pstmt.executeUpdate();

            // PreparedStatement 객체와 데이터베이스 연결을 닫습니다.
            pstmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            // 데이터베이스 연결이나 쿼리 실행 중 발생하는 예외를 처리합니다.
            e.printStackTrace();
        }

        // 처리가 완료되면 회원 목록 페이지로 리디렉션합니다.
        response.sendRedirect("/admin/AdminBoardList.jsp");
    }
}