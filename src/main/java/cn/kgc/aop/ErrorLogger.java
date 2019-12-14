package cn.kgc.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 定义包含增强方法的JavaBean
 */
/*
 * @Component
 * 
 * @Aspect
 */
public class ErrorLogger {
	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	/*
	 * @Pointcut("execution(* cn.kgc.service..*.*(..))") public void
	 * pointcut(){}
	 */

	@AfterThrowing(pointcut = "execution(* cn.kgc.service..*.*(..))", throwing = "e")
	public void afterThrowing(JoinPoint jp, RuntimeException e) {
		logger.info(jp.getSignature().getName() + " 方法发生异常：" + e);
	}
}