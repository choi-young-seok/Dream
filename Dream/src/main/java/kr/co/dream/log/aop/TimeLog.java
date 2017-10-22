package kr.co.dream.log.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeLog {

	private static final Logger logger = LoggerFactory.getLogger(TimeLog.class);
	
//	@Around("execution(* kr.co.dream..*.*(..))")
//	@Around("execution(* kr.co.dream..service*.*(..))")
	@Around("execution(* *..*Service.*(..))")
	public Object timeLog(ProceedingJoinPoint joinPoint)throws Throwable{
		logger.info("-------------------------------");
		logger.info("���� : " + joinPoint.toLongString());
		logger.info("�޼ҵ� ���� ��");
		System.out.println("�޼ҵ� ���� ��");
		
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(joinPoint.getArgs()));
		
		Object result = joinPoint.proceed();
		logger.info("���� �� : " +result);
		
		long endTime = System.currentTimeMillis();
		logger.info("�Ҹ�ð� : "+joinPoint.getSignature().getName()+" : " +(endTime -startTime));
		logger.info("�޼ҵ� ���� ��");
		logger.info("===============================");
		
		return result;
	}
}
