package at.danicoz.user.service;

import java.sql.Connection;
import java.sql.SQLException;

import at.danicoz.dao.UserDao;
import at.danicoz.user.dao.impl.UserDaoImpl;
import at.danicoz.user.po.User;
import at.danicoz.util.DBUtils;

public class UserService {

	private static final UserService instance = new UserService();
	public static UserService getInstance(){
		return instance;
	}
	
	private UserService(){
		
	}
	
	public void addUser(User user){
		Connection conn = null;
		
		try{
		conn = DBUtils.getConnection();
		UserDao userDao = new UserDaoImpl(conn);
		DBUtils.beginTransaction(conn);
		userDao.save(user);
		DBUtils.commit(conn);
		}catch(SQLException e){
			DBUtils.rollback(conn);
			e.printStackTrace();
		}
		finally{
			DBUtils.closeConnection(conn);
		}
	}
	
	public User findUser(User one){
		User user = null;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			user = userDao.findUser(one);
			DBUtils.commit(conn);
		}catch(SQLException e){
			DBUtils.rollback(conn);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return user;
	}
	
	//更新用户信息
	public boolean updateUser(User one){
		Connection conn = null;
		boolean res = false;
		
		try{
			conn = DBUtils.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			res = userDao.updateUser(one);
			DBUtils.commit(conn);
		}catch(SQLException e){
			DBUtils.rollback(conn);
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
		return res;
	}

	//登录验证
	public User login(String username, String password) {
		User user = null;
		Connection conn = null;
		
		try{
			conn = DBUtils.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			user = userDao.login(username, password);
			DBUtils.commit(conn);
		}catch(SQLException e){
			DBUtils.rollback(conn);
			
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
		return user;
	}
	
	
	
	
	
}
