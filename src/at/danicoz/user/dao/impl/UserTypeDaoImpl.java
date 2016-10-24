package at.danicoz.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import at.danicoz.dao.UserTypeDao;
import at.danicoz.user.po.UserType;
import at.danicoz.util.DBUtils;



public class UserTypeDaoImpl implements UserTypeDao {

	/**
	 * 数据库连接
	 */
	private Connection conn;

	/**
	 * 构造方法
	 * 
	 * @param conn
	 *            数据库连接
	 */
	public UserTypeDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<UserType> getUserTypeList() throws SQLException {
		//SQL语句
		String find_sql = "SELECT * FROM t_usertype";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserType> result = new ArrayList<UserType>();
		try {
			//设置语句对象，SQL语句条件
			pstmt = conn.prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//解析结果集对象
				UserType one = new UserType();
				one.setId(rs.getInt("id"));
				one.setContent(rs.getString("content"));
				
				//保存证件信息列表
				result.add(one);
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		
		return result;
	}

}
