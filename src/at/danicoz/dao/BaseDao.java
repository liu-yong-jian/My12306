package at.danicoz.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class BaseDao {
	//定义数据库对象
	private Connection conn = null;
	//参数化的执行对象
	private PreparedStatement pment = null;
	//过程化的执行对象？？？？
	private CallableStatement cment = null;
	
	private ResultSet rs = null;
	
	public BaseDao(){
		
	}
	
	//获取数据库连接
	private void getConnection(){
		try{
			Context cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup("java:comp/env/jdbc/My12306");
			System.out.println("测试Git功能");
			conn = ds.getConnection();
		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//关闭数据库操作对象
	private void closeAllObject(){
		try{
			if(rs != null){
				rs.close();
			}
			if(pment != null){
				pment.close();
			}
			if(cment != null){
				cment.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//受影响的行数
	public int getNonQuery(String sql,Object[] oParams){
		int iNonQuery = 0;
		getConnection();
		
		try{
			//带sql 执行对象
			pment = conn.prepareStatement(sql);
			//判断参数对象
			if(oParams != null && oParams.length>0){
				for(int i=0;i<oParams.length;i++){
					//添加参数到sql中
					pment.setObject(i+1, oParams[i]);
				}
			}
			iNonQuery = pment.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeAllObject();
		}
		return iNonQuery;
		
	}
	
	//查询结果集
	public ResultSet getResultSet(String sql,Object[] oParams){
		rs = null;
		getConnection();
		
		try{
			pment = conn.prepareStatement(sql);
				if(oParams != null && oParams.length>0){
					for(int i=0;i<oParams.length;i++){
						//添加参数到sql中
						pment.setObject(i+1, oParams[i]);
					}
			}
				rs = pment.executeQuery();
		}
			
			catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
		
		
}
