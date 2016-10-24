package at.danicoz.dao;

import java.sql.SQLException;

import at.danicoz.user.po.User;

public interface UserDao {
	
	//增加用户方法,返回的是整数（1表示成功插入，否不成功）
	int save(User user) throws SQLException;
	
	//删除用户
	boolean deleteUsers(int[] UserIdList)throws SQLException;
	
	//通过用户信息查找用户
	User findUser(User user) throws SQLException;
	
	//验证登录信息
	User login(String username,String password)throws SQLException;

	boolean updateUser(User one)throws SQLException;
	
}
