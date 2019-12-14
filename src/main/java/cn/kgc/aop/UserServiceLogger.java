package cn.kgc.aop;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 增强类
 * 
 * @author KangJonney
 *
 */
// @Component
// @Aspect
public class UserServiceLogger {
	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public void before(JoinPoint jp) {
		logger.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName() + " 方法。方法入参："
				+ Arrays.toString(jp.getArgs()));
	}

	public void afterReturning(JoinPoint jp, Object result) {
		logger.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName() + " 方法。方法返回值：" + result);
	}

}