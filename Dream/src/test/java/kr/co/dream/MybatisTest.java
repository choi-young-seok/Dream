package kr.co.dream;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//SqlSession객체 확인!! ----> iBatis의 SqlMapClient 역할

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MybatisTest {
  
  @Inject
  private SqlSessionFactory sqlFactory;	
  //root-context.xml 의 SqlSessionFactoryBean객체를 주입
	
  @Test
  public void testFactory(){
	  if(sqlFactory != null){
		  System.out.println("sqlSessionFactory객체 생성 성공");
		  System.out.println("SqlFactory: "+ sqlFactory);  
	  }else{
		  System.out.println("sqlSessionFactory객체 생성 실패");
		  System.out.println("root-context DB관련 환경설정 확인 요망");
	  }
  }	
	
  @Test
  public void testSession()throws Exception{
	 SqlSession sqlSession = sqlFactory.openSession(); 
	 //iBatis (SqlMapClient)  ==  MyBatis (SqlSession)
	 System.out.println("Session: "+ sqlSession);
  }	
}








