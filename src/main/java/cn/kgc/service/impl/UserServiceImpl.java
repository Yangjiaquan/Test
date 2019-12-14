package cn.kgc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import cn.kgc.entity.User;
import cn.kgc.mapper.UserMapper;
import cn.kgc.service.UserService;

/**
 * 用户业务类，实现对User功能的业务管理
 */
// @Transactional
@Service
public class UserServiceImpl implements UserService {
	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	// 声明接口类型的引用，和具体实现类解耦合
	@Resource
	private UserMapper userMapper;


	@Override
	public boolean UserdengLu(User user) {
//		User user=new User();
//		user.setUserName(userName);
//		user.setUserPassword(userPassWord);
		List<User> user2=userMapper.queryUserList(user);
		if (user2.size()>=1) {
			return true;
		}
		return 	false;
	}

	/**
	 * 通用查询
	 */
	@Override
	public List<User> queryUserList(User user) {
		List<User> list=userMapper.queryUserList(user);
		return list;
	}

}