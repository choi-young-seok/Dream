package kr.co.dream;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
// @RunWith(SpringJUnit4ClassRunner.class) : JUnitŬ������ �̿��� �׽�Ʈ ����

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
// @ContextConfiguartion�� ����
// = root-context.xml�� ��ϵ� Ŭ����(<context:component-scan base-package="com.kosta.persistence" />)
// �� DAO �������̽��� ������ DAOImplŬ�����κ��� DAO�� ���� ��ü ������ @Inject�� �����ϱ� ����

public class DAOTest {
	// �ۼ��� BoardDAO�� ������ BoardDAOImpl.java�� boardMapper.xml�� ���� �׽�Ʈ�� ����
	// DAO���� ������ �޼ҵ带 ������ DAOImpl Ŭ������ �޼ҵ带 �����ϱ� ���� �޼ҵ带 �ۼ� �� �׽�Ʈ�� ����
	// = �׽�Ʈ�� ����� �ش� �޼ҵ忡 @Test ������̼��� �߰��Ͽ� �ش� �޼ҵ带 �׽�Ʈ
	// = �׽�Ʈ�� �������� ���� �ÿ��� @Test ������̼��� �ּ�ó��
	// = ������ ����� Ȥ�� �׽��� ����� ���� ���� Logger �������̽��� ������ LoggerFactory�� ���
	// = LoggerFactory.info/error/warning/debug

	private static final Logger logger = LoggerFactory.getLogger(DAOTest.class);
	// = ������ ����� Ȥ�� �׽��� ����� ���� ���� Logger �������̽��� ������ LoggerFactory�� ���
	// = LoggerFactory.info/error/warning/debug

	
}
