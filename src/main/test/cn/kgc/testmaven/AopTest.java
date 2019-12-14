package cn.kgc.testmaven;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.kgc.entity.User;
import cn.kgc.service.UserService;

//指定单元测试环境
@RunWith(SpringJUnit4ClassRunner.class)
// 指定配置文件路径
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class AopTest {
	
	static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Resource
	private UserService userService;

	@Test
	public void testName() throws Exception {
		User user =new User();
		user.setPhone("1837717001");
//		List<User> user2 = userService.getUserList(user);
	}

}
