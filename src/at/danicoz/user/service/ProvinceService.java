package at.danicoz.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import at.danicoz.dao.ProvinceDao;
import at.danicoz.user.dao.impl.ProvinceDaoImpl;
import at.danicoz.user.po.Province;
import at.danicoz.util.DBUtils;


/**
 * 省份服务类（采用单例模式实现）
 */
public class ProvinceService {
	/**
	 * 类实例
	 */
	private static final ProvinceService instance = new ProvinceService();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static ProvinceService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private ProvinceService() {
	}
	
	/**
	 * 获取所有省份列表
	 * @return 省份信息列表
	 * @throws SQLException
	 */
	public List<Province> getProvinceList(){
		Connection conn = null;
		List<Province> res = null;
		try {
			conn = DBUtils.getConnection();
			ProvinceDao provinceDao = new ProvinceDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			res = provinceDao.getProvinceList();
			DBUtils.commit(conn);
		} catch (SQLException e) {
			DBUtils.rollback(conn);
			
		} finally {
			DBUtils.closeConnection(conn);
		}
		
		return res;
	}
}
