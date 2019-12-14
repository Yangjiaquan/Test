package cn.kgc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kgc.entity.User;
import cn.kgc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/login.com")
	public String login() {
		System.out.println("进来login.com");
		return "login";
	}
	@RequestMapping(value = "/loginDL", produces = { "text/html;charset=UTF-8;", "application/json;" })
	@ResponseBody
	public String loginDL(@RequestBody(required = true) User user,HttpSession session,HttpServletResponse response) {
		System.out.println("进来登录Servlet"+user.getUserName()+"<<<");
		boolean isOk=userService.UserdengLu(user);
		if (isOk) {
			List<User> list=userService.queryUserList(user);
			User user2=list.get(0);
			session.setAttribute("User", user2);
			return "Y";
		}
		return "N";
	}
	@RequestMapping(value="/frame.com")
	public String frame(HttpSession session,HttpServletRequest request){
		if (session.getAttribute("User")==null) {
			return "redirect:/user/login.com";
		}
		User user=(User) session.getAttribute("User");
		request.setAttribute("userName", user.getUserName());
		return "frame";
	}
}
