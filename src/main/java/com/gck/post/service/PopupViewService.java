package com.gck.post.service;

import com.gck.factory.MyBatisFactory;
import com.gck.post.model.PostDAO;
import com.gck.post.model.PostVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class PopupViewService {

    SqlSession sqlSession;
    PostDAO mapper;

    public PopupViewService(){

    }

    public List<PostVO> selectPopupView(Map <String,Object> map){
      this.sqlSession = MyBatisFactory.getSqlSession();
      mapper = this.sqlSession.getMapper(PostDAO.class);

      List<PostVO> popupView = mapper.selectPopupView(map);
      System.out.println("test : ================ " + popupView);
      sqlSession.close();
      return popupView;
    }

    public int updateVisitCount(String postIdx){
      this.sqlSession = MyBatisFactory.getSqlSession();
      mapper = this.sqlSession.getMapper(PostDAO.class);

      int result = mapper.updateVisitCount(postIdx);
      System.out.println("test : ================ " + result);
      sqlSession.close();
      return result;
    }

}
