package at.danicoz.dao;

import java.sql.SQLException;
import java.util.List;

import at.danicoz.user.po.User;

/**
 * 用户表操作接口
 */
public interface UserDao {
	
	/**
	 * 增加用户
	 * 
	 * @param user
	 *            用户对象
	 * @throws SQLException
	 */
	int save(User user) throws SQLException;
	
	/**
	 * 删除用户(采用IN方式完成)
	 * 
	 * @param userIdList
	 *            用户ID的集合
	 * @throws SQLException
	 */
	boolean deleteUsers(int[] userIdList) throws SQLException;
	
	/**
	 * 删除用户(采用调用存储过程完成)
	 * @param userIdList
	 * @return 操作是否成功
	 * @throws SQLException
	 */
	boolean deleteUsersProcedure(int[] userIdList) throws SQLException;
	
	/**
	 * 通过用户名、密码验证登录用户信息
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return user 用户信息，若用户名、密码不相符返回对象为null
	 * @throws SQLException
	 */
	User login(String username, String password) throws SQLException;
	
	/**
	 * 通过用户信息查询用户
	 * @param 用户信息，逐项信息查询，信息为空说明该查询条件为空
	 * @return 用户信息，若未查到符合条件用户则返回对象为null
	 * @throws SQLException
	 */
	User findUser(User user) throws SQLException;
	
	/**
	 * 获取用户列表最大页数
	 * @param pageSize，每页显示信息条数
	 * @return 列表最大页数
	 * @throws SQLException
	 */
	int getUserListRowCount(int pageSize) throws SQLException;
	
	/**
	 * 获取指定页用户信息列表，通过分页SQL语句实现
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param one，需要获取的页数
	 * @return 用户信息列表，List[User]，若无满足条件则列表为空
	 * @throws SQLException
	 */
	List<User> getUserList(int pageSize, int rowNum, User one) throws SQLException;
	
	/**
	 * 获取指定页用户信息列表，通过分析结果集ResultSet对象实现
	 * @param pageSize，每页显示信息条数
	 * @param pageNum，需要获取的页数
	 * @param one，需要获取的页数
	 * @return 用户信息列表，List[User]，若无满足条件则列表为空
	 * @throws SQLException
	 */
	List<User> getUserListRS(int pageSize, int pageNum, User one) throws SQLException;
	
	/**
	 * 更新用户信息
	 * @param one，需要更新的用户信息对象
	 * @return 执行是否成功
	 * @throws SQLException
	 */
	boolean updateUser(User one) throws SQLException;

	int getUserListPageCount(int pageSize, User one) throws SQLException;

	int getUserListRowCount(User one)throws SQLException;
}
