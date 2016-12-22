package kr.co.dream;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
// @RunWith(SpringJUnit4ClassRunner.class) : JUnit클래스를 이용한 테스트 진행

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
// @ContextConfiguartion의 역할
// = root-context.xml에 등록된 클래스(<context:component-scan base-package="com.kosta.persistence" />)
// 중 DAO 인터페이스를 구현한 DAOImpl클래스로부터 DAO에 대한 객체 생성을 @Inject로 진행하기 위함

public class DAOTest {
	// 작성한 BoardDAO를 구현한 BoardDAOImpl.java와 boardMapper.xml에 대한 테스트를 진행
	// DAO에서 정의한 메소드를 구현한 DAOImpl 클래스의 메소드를 수행하기 위한 메소드를 작성 및 테스트를 진행
	// = 테스트를 진행시 해당 메소드에 @Test 어노테이션을 추가하여 해당 메소드를 테스트
	// = 테스트를 진행하지 않을 시에는 @Test 어노테이션을 주석처리
	// = 각각의 결과값 혹은 테스팅 결과를 보기 위해 Logger 인터페이스를 구현한 LoggerFactory를 사용
	// = LoggerFactory.info/error/warning/debug

	private static final Logger logger = LoggerFactory.getLogger(DAOTest.class);
	// = 각각의 결과값 혹은 테스팅 결과를 보기 위해 Logger 인터페이스를 구현한 LoggerFactory를 사용
	// = LoggerFactory.info/error/warning/debug

	
}
