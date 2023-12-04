package com.gck.admin.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//*회원정보 조회* //

@WebServlet("/MemberListServlet")
public class AdminBoardListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 데이터베이스 연결 및 SQL 쿼리 실행을 위한 객체를 선언합니다.
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // MySQL JDBC 드라이버를 로드합니다.
            Class.forName("com.mysql.jdbc.Driver");

            // 데이터베이스 연결 정보 설정
            String DB_URL = "jdbc:mysql://localhost:3306/member";
            String DB_USER = "root";
            String DB_PASSWORD = "12345";

            // 데이터베이스에 연결합니다.
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL 문을 실행하기 위한 Statement 객체 생성합니다.
            stmt = conn.createStatement();

            // 회원 정보를 조회하는 SQL 쿼리
            String query = "SELECT idx, id, name, pwd FROM member";

            // 쿼리 실행 후 결과를 ResultSet 객체에 저장합니다.
            rs = stmt.executeQuery(query);

            // 조회 결과인 ResultSet을 request의 속성으로 설정합니다.
            request.setAttribute("resultSet", rs);

            // AdminBoardList.jsp 페이지로 포워딩, 결과를 해당 페이지에 전달합니다.
            request.getRequestDispatcher("/admin/AdminBoardList.jsp").forward(request, response);
        } catch (Exception e) {

            // 예외 발생 시 로그 출력합니다.
            e.printStackTrace();
        } finally {
            // 데이터베이스 연결을 닫지 않음
            // JSP 페이지에서 ResultSet 사용 후 닫을 예정
        }
    }
}
