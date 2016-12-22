package kr.co.dream;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/*.xml"})
// 여러개의 root-context.xml에 관한 설정을 전부 로드
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class DBConnectTest {

	@Inject
	// root-context에 있는 DataSource객체 외부주입
	private DataSource ds;

	@Test
	public void testConnection() throws Exception {

		Connection conn = ds.getConnection();
		if(conn != null){
			System.out.println("DataBase연결 성공");
			System.out.println("Connection객체 : " + conn);	
		}else{
			System.out.println("root-context.xml DB관련 환경설정 확인 요망");
		}
	}
}
