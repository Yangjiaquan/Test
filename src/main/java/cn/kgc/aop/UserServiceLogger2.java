package cn.kgc.aop;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 增强类使用注解
 * 
 * @author KangJonney
 * 
 */
// @Component
// @Aspect
public class UserServiceLogger2 {
	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Pointcut("execution(* cn.kgc.service..*.*(..))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void before(JoinPoint jp) {
		logger.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName() + " 方法。方法入参："
				+ Arrays.toString(jp.getArgs()));
	}

	/*
	 * @Before("execution(* cn.kgc.service..*.*(..))") public void before(){
	 * System.out.println("前置增强"); }
	 */

	@AfterReturning(pointcut = "pointcut()", returning = "result")
	public void afterReturning(JoinPoint jp, Object result) {
		logger.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName() + " 方法。方法返回值：" + result);
	}

}