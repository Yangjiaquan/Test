package cn.kgc.service;

import java.util.List;
import cn.kgc.entity.User;

/**
 * 用户业务接口，定义了所需的业务方法
 */
public interface UserService {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<User> queryUserList(User user);
	/**
	 * 根据姓名密码判断用户登录
	 * @param userName
	 * @param userPassWord
	 * @return
	 */
	public boolean UserdengLu(User user);
}
