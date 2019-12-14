package cn.kgc.aop;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
public class AroundLogger {
	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Around("execution(* cn.kgc.service..*.*(..))")
	public Object aroundLogger(ProceedingJoinPoint jp) throws Throwable {
		logger.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName() + " 方法。方法入参："
				+ Arrays.toString(jp.getArgs()));
		try {
			Object result = jp.proceed();
			logger.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName() + " 方法。方法返回值：" + result);
			return result;
		} catch (Throwable e) {
			logger.error(jp.getSignature().getName() + " 方法发生异常：" + e);
			throw e;
		} finally {
			logger.info(jp.getSignature().getName() + " 方法结束执行。");
		}

	}
}