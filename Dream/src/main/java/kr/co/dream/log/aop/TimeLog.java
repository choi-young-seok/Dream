package kr.co.dream.log.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
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
	public Object timeLog(ProceedingJoinPoint joinPoint)throws Throwable{
		System.out.println("왜안되냐 도대체");
		logger.info("-------------------------------");
		logger.info("-------------------------------");
		
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(joinPoint.getArgs()));
		
		Object result = joinPoint.proceed();
		
		long endTime = System.currentTimeMillis();
		logger.info(joinPoint.getSignature().getName()+" : " +(endTime -startTime));
		logger.info("===============================");
		
		return result;
	}
}
