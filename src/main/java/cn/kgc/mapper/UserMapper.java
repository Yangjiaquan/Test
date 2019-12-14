package cn.kgc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.kgc.entity.User;

/**
 * 增加DAO接口,定义了所需的持久化方法
 */
public interface UserMapper {
	/**
	 * 动态SQL查询用户列表信息
	 * 
	 * @return
	 */
	public List<User> queryUserList(User user);

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int queryUserCount();

	/**
	 * 模糊查询
	 * 
	 * @return
	 */
	public List<User> queryUserListByUserName(String userName);

	/**
	 * 多条件查询
	 * 
	 * @param map
	 * @return
	 */
	public List<User> queryUserListByMap(Map<String, String> map);

	/**
	 * 插入用户记录
	 * 
	 * @param user
	 * @return
	 */
	public int inertUser(User user);

	/**
	 * 
	 * @param user
	 * @return
	 */
	public int updateUserById(User user);

	/**
	 * 根据ID删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	public int delUserById(@Param("id") int id);

	/**
	 * 获取指定用户的相关信息及其地址列表
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserAndAddressListById(@Param("id") int id);

	/**
	 * 根据多个角色id查询用户列表之数组
	 * 
	 * @param ids
	 * @return
	 */
	public List<User> queryUserListByRoleIds_Array(int[] ids);

	/**
	 * 根据多个角色id查询用户列表之list
	 * 
	 * @param ids
	 * @return
	 */
	public List<User> queryUserListByRoleIds_List(List<Integer> ids);

	/**
	 * 根据性别和多个角色id查询用户列表之
	 * 
	 * @param ids
	 * @return
	 */
	public List<User> queryUserListByRoleIdsAndGender(Map<String, Object> map);

	/**
	 * 多条件查询之choose
	 * 
	 * @param map
	 * @return
	 */
	public List<User> queryUserList_choose(Map<String, String> map);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<User> queryUserList_page(@Param("from") int from, @Param("pageSize") int pageSize);

	/**
	 * 登录
	 * 
	 * @param userCode
	 * @return
	 */
	public User getLoginUser(@Param("userName") String userName, @Param("passWord") String passWord);

	/**
	 * 根据条件查询用户表记录数
	 * 
	 * @param queryUserName
	 * @param queryUserRole
	 * @return
	 */
	public int getUserCount(@Param("queryUserName") String queryUserName,
			@Param("queryUserRole") Integer queryUserRole);

	/**
	 * 根据条件查询用户列表
	 * 
	 * @param queryUserName
	 * @param queryUserRole
	 * @return
	 */
	public List<User> getUserList(Map<String, Object> map);

}
