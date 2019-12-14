package cn.kgc.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*@Component
@Aspect*/
public class AfterLogger {
	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@After("execution(* cn.kgc.service..*.*(..))")
	public void after(JoinPoint jp) {
		logger.info(jp.getSignature().getName());
	}

}
