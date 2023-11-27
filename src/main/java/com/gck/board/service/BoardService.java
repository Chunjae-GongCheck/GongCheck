package com.gck.board.service;

import com.gck.board.model.BoardVO;
import com.gck.post.model.PostDAO;
import com.gck.post.model.PostVO;
import org.apache.ibatis.session.SqlSession;

import com.gck.factory.MyBatisFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BoardService {
    // DAO
    SqlSession sqlSession;
    PostDAO mapper;

    // 생성자
    public BoardService() {

    }


//     서비스 메서드 시작, 종료할 때 반드시 넣어 주세요!
//     시작 시,
//     this.sqlSession = MyBatisFactory.getSqlSession(); mapper = this.sqlSession.getMapper(BoardDAO.class);
//     종료 시,
//     sqlSession.close();


    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
    public List<BoardVO> selectListPage() {
        this.sqlSession = MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(PostDAO.class);

        List<BoardVO> list = mapper.selectListPage();

        sqlSession.close();
        return list;
    }
//
//    // 전체 페이지 수 구하기
//    public int getPageCount(int numPerPage, int dataCount) {
//        int pageCount = 0;
//
//        pageCount = dataCount / numPerPage;
//
//        if (dataCount % numPerPage != 0)
//            pageCount++;
//
//        return pageCount;
//    }
//
//    public String listPaging(int currentPage, int totalPage, String listUrl) {
//        StringBuffer strList = new StringBuffer();
//        int numPerBlock = 10;
//
//        int currentPageSetup;
//        int page;
//        int n;
//
//        if (currentPage == 0) {
//            return "";
//        }
//        if (listUrl.indexOf("?") != -1)
//            listUrl = listUrl + "&";
//        else listUrl = listUrl + "?";
//
//        currentPageSetup = (currentPage / numPerBlock) * numPerBlock;
//        if (currentPage % numPerBlock == 0)
//            currentPageSetup = currentPageSetup - numPerBlock;
//
//        if ((totalPage > numPerBlock) && (currentPageSetup > 0))
//            strList.append(" <a hef ='" + listUrl + "pageNum = 1'>1</a>");
//
//        n = currentPage - numPerBlock;
//        if ((totalPage > numPerBlock) && (currentPageSetup > 0)) {
//            strList.append(" <a href='" + listUrl + "pageNum = " + n + "'>Prev</a>");
//        }
//
//        page = currentPageSetup + 1;
//
//        while ((page <= totalPage) && (page <= currentPageSetup + numPerBlock)) {
//            if (page == currentPage)
//                strList.append(" <span style='color:orange; font-weight:bold;'>" + page + "</span>");
//            else
//                strList.append(" <a href = '" + listUrl + "pageNum=" + page + "'>" + page + "</a>");
//
//            page++;
//
//        }
//        n = currentPage + numPerBlock;
//        if ((totalPage - currentPageSetup) > numPerBlock)
//            strList.append(" <a href ='" + listUrl + "gateNum" + n + "'>Next</a>");
//
//        if((totalPage>numPerBlock) && ((currentPageSetup + numPerBlock)<totalPage))
//            strList.append(" <a href = '" + listUrl + "pageNum=" + totalPage +  "'>" + totalPage + "</a>");
//    }
}
