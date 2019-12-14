package cn.kgc.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
@RestControllerAdvice
public class ExceptionResolver{
	@ExceptionHandler
    public String exceptionHandler(Exception e){
    	return "";
    }
}
