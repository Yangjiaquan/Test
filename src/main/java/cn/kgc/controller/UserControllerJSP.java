package cn.kgc.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;

import cn.kgc.entity.User;
import cn.kgc.service.UserService;
import cn.kgc.tools.Constants;
import cn.kgc.tools.PageSupport;

@Controller
@RequestMapping("/userr")
public class UserControllerJSP {
	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Resource
	private UserService userService;

	@RequestMapping(value = "/index.html", produces = { "text/html;charset=UTF-8;", "application/json;" })
	@ResponseBody
	public String index(@RequestBody(required = true) User user) throws ParseException {
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-mm-dd");
		simp.format(user.getUserDate());
		System.out.println("进来" + user.getUserName() + user.getPhone());
		System.out.println("日期:" + user.getUserDate());
		return JSON.toJSONString(user);
	}

	@RequestMapping(value = "/login.html")
	public String login() {
		logger.debug("UserController welcome SMBMS==================");
		return "login";
	}

	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	public String doLogin(@RequestParam String userCode, @RequestParam String userPassword, HttpServletRequest request,
			HttpSession session) {
		logger.debug("doLogin====================================");
		// 调用service方法，进行用户匹配
		return "redirect:/user/main.html";
		// User user = userService.login(userCode,userPassword);
		// if(null != user){//登录成功
		// //放入session
		// session.setAttribute(Constants.USER_SESSION, user);
		// //页面跳转（frame.jsp）
		// return "redirect:/user/main.html";
		// //response.sendRedirect("jsp/frame.jsp");
		// }else{
		// //页面跳转（login.jsp）带出提示信息--转发
		// request.setAttribute("error", "用户名或密码不正确");
		// return "login";
		// }
	}

	@RequestMapping(value = "/main.html")
	public String main(HttpSession session) {
		// if(session.getAttribute(Constants.USER_SESSION) == null){
		// return "redirect:/user/login.html";
		// }
		return "frame";
	}

	@RequestMapping(value = "/logout.html")
	public String logout(HttpSession session) {
		// 清除session
		session.removeAttribute(Constants.USER_SESSION);
		return "login";
	}

	@RequestMapping(value = "/exlogin.html", method = RequestMethod.GET)
	public String exLogin(@RequestParam String userCode, @RequestParam String userPassword) {
		logger.debug("exLogin====================================");
		// 调用service方法，进行用户匹配
//		User user = userService.login(userCode, userPassword);
//		if (null == user) {// 登录失败
//			throw new RuntimeException("用户名或者密码不正确！");
//		}
		return "redirect:/user/main.html";
	}

	/*
	 * @ExceptionHandler(value={RuntimeException.class}) public String
	 * handlerException(RuntimeException e,HttpServletRequest req){
	 * req.setAttribute("e", e); return "error"; }
	 */

	@RequestMapping(value = "/userlist.html")
	public String getUserList(Model model) {
		// ,
		// @RequestParam(value="queryname",required=false) String queryUserName,
		// @RequestParam(value="queryUserRole",required=false) String
		// queryUserRole,
		// @RequestParam(value="pageIndex",required=false) String pageIndex
		// logger.info("getUserList ---- > queryUserName: " + queryUserName);
		// logger.info("getUserList ---- > queryUserRole: " + queryUserRole);
		// logger.info("getUserList ---- > pageIndex: " + pageIndex);
		// Integer _queryUserRole = null;
		// List<User> userList = null;
		// //设置页面容量
		// int pageSize = Constants.pageSize;
		// //当前页码
		// int currentPageNo = 1;
		//
		// if(queryUserRole != null && !queryUserRole.equals("")){
		// _queryUserRole = Integer.parseInt(queryUserRole);
		// }
		//
		// if(pageIndex != null){
		// try{
		// currentPageNo = Integer.valueOf(pageIndex);
		// }catch(NumberFormatException e){
		// return "redirect:/user/syserror.html";
		// //response.sendRedirect("syserror.jsp");
		// }
		// }
		// //总数量（表）
		// int totalCount = 0;
		// try {
		// totalCount = userService.getUserCount(queryUserName,_queryUserRole);
		// } catch (RuntimeException exception) {
		// // TODO: handle exception
		// }
		// //总页数
		// PageSupport pages=new PageSupport();
		// pages.setCurrentPageNo(currentPageNo);
		// pages.setPageSize(pageSize);
		// pages.setTotalCount(totalCount);
		// int totalPageCount = pages.getTotalPageCount();
		// //控制首页和尾页
		// if(currentPageNo < 1){
		// currentPageNo = 1;
		// }else if(currentPageNo > totalPageCount){
		// currentPageNo = totalPageCount;
		// }
		// userList =
		// userService.getUserList(queryUserName,_queryUserRole,currentPageNo,pageSize);
		// model.addAttribute("userList", userList);
		// List<Role> roleList = null;
		// roleList = roleService.getRoleList();
		// model.addAttribute("roleList", roleList);
		// model.addAttribute("queryUserName", queryUserName);
		// model.addAttribute("queryUserRole", queryUserRole);
		// model.addAttribute("totalPageCount", totalPageCount);
		// model.addAttribute("totalCount", totalCount);
		// model.addAttribute("currentPageNo", currentPageNo);
		return "userlist";
	}

	@RequestMapping(value = "/syserror.html")
	public String sysError() {
		return "syserror";
	}

	@RequestMapping(value = "/useradd.html", method = RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User user) {
		return "useradd";
	}

	/*
	 * @RequestMapping(value="/useradd.html",method=RequestMethod.GET) public
	 * String addUser(User user,Model model){ model.addAttribute("user", user);
	 * return "useradd"; }
	 */

	/*
	 * @RequestMapping(value="/useraddsave.html",method=RequestMethod.POST)
	 * public String addUserSave(User user,HttpSession session){
	 * user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).
	 * getId()); user.setCreationDate(new Date()); if(userService.add(user)){
	 * return "redirect:/user/userlist.html"; } return "useradd"; }
	 */
}
