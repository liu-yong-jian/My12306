package at.danicoz.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import at.danicoz.dao.CertTypeDao;
import at.danicoz.user.dao.impl.CertTypeDaoImpl;
import at.danicoz.user.po.CertType;
import at.danicoz.util.DBUtils;


/**
 * 证件类型服务类（采用单例模式实现）
 */
public class CertTypeService {
	/**
	 * 类实例
	 */
	private static final CertTypeService instance = new CertTypeService();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static CertTypeService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private CertTypeService() {
	}
	
	/**
	 * 获取所有证件类型列表
	 * @return 证件类型列表
	 * @throws SQLException
	 */
	public List<CertType> getCertTypeList(){
		Connection conn = null;
		List<CertType> res = null;
		try {
			conn = DBUtils.getConnection();
			CertTypeDao certTypeDao = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			res = certTypeDao.getCertTypeList();
			DBUtils.commit(conn);
		} catch (SQLException e) {
			DBUtils.rollback(conn);
			
		} finally {
			DBUtils.closeConnection(conn);
		}
		
		return res;
	}
}
