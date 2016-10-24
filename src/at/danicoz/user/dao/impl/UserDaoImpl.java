package at.danicoz.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import at.danicoz.dao.UserDao;
import at.danicoz.user.po.CertType;
import at.danicoz.user.po.City;
import at.danicoz.user.po.User;
import at.danicoz.user.po.UserType;
import at.danicoz.util.DBUtils;

public class UserDaoImpl implements UserDao {

	//锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟�
	private Connection conn;
	
	//通锟斤拷锟届方锟斤拷锟斤拷取 conn 锟斤拷锟斤拷锟绞硷拷锟�
	public UserDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	
	@Override
	public int save(User user) throws SQLException {
		// TODO Auto-generated method stub
		String save_sql = "INSERT INTO t_user VALUES(T_USER_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstm = null;
		
		int row = 0;//锟斤拷莘锟斤拷锟街碉拷卸锟斤拷欠锟斤拷锟斤拷晒锟�
		int idx = 1;
		try {

			pstm = conn.prepareStatement(save_sql);
			
			pstm.setString(idx, user.getUsername());
			pstm.setString(++idx, user.getPassword());

			pstm.setString(++idx, user.getRule());
			pstm.setString(++idx, user.getRealname());
			pstm.setString(++idx, user.getSex());
			pstm.setInt(++idx, user.getCity().getId());
			pstm.setInt(++idx, user.getCertType().getId());

			pstm.setString(++idx, user.getCert());
			pstm.setDate(++idx, new java.sql.Date(user.getBirthday().getTime()));

			pstm.setInt(++idx, user.getUserType().getId());

			pstm.setString(++idx, user.getContent());
			pstm.setString(++idx, user.getStatus());
			pstm.setString(++idx, user.getLoginIp());
			
			pstm.setString(++idx, user.getImagePath());

			row = pstm.executeUpdate();
		} finally {
			DBUtils.closeStatement(null, pstm);
		}

		return row;

	}
	
	
	@Override
	public boolean deleteUsers(int[] UserIdList) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUser(User one) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer find_sql = new StringBuffer("select * from t_user where 1=1");
		
		boolean tag = false;
		Integer id = one.getId();
		if(id!=null && id!=0){
		find_sql.append("AND id="+id);
		tag = true;
		}
		
		//username
		String username = one.getUsername();
		if(username != null && !username.isEmpty()){
			find_sql.append("AND username='"+username+"'");//
			tag = true;
		}
		
		//password
		String password = one.getPassword();
		if(password!=null && !password.isEmpty()){
			find_sql.append("AND password='"+password+"'");
			tag = true;
		}
		
		//rule
		String rule = one.getRule();
		if(rule!=null && !rule.isEmpty()){
			find_sql.append("AND rule='"+rule+"'");
			tag = true;
		}
		
		//realname
		String realname = one.getRealname();
		if(realname!=null && !realname.isEmpty()){
			find_sql.append("AND realname like'%"+realname+"%'");
			tag = true;
		}
		
		//sex
		String sex = one.getSex();
		if(sex!=null && !sex.isEmpty()){
			find_sql.append("AND sex='"+sex+"'");
			tag = true;
		}
		
		//city
		if(one.getCity()!=null){
			int city = one.getCity().getId();
			if(city!=0){
				find_sql.append("AND city="+city);
				tag = true;
			}
		}
		
		//certType
		if(one.getCertType()!=null){
			int cert_type = one.getCertType().getId();
			if(cert_type!=0){
				find_sql.append("AND cert_type="+cert_type);
				tag = true;
			}
		}
		
		//cert
		String cert = one.getCert();
		if(cert!=null && !cert.isEmpty()){
			find_sql.append("AND cert like'%"+cert+"%'");
			tag = true;
		}
		
		//userType
		if(one.getUserType()!=null){
			int userType = one.getUserType().getId();
			if(userType!=0){
				find_sql.append("AND user_type="+userType);
				tag = true;
			}
		}
		
		//content
		String content = one.getContent();
		if(content!=null && !content.isEmpty()){
			find_sql.append("AND content like'%"+content+"%'");
			tag = true;
		}
		
		//statues
		String status = one.getStatus();
		if(status!=null && !status.isEmpty()){
			find_sql.append("AND status ='"+status+"'");
			tag = true;
		}
		
		//loginip
		String ip = one.getLoginIp();
		if(ip!=null && !ip.isEmpty()){
			find_sql.append("AND login_ip ='"+ip+"'");
			tag = true;
		}
		
		//imagepath
		String image = one.getImagePath();
		if(image!=null && !image.isEmpty()){
			find_sql.append("AND image_path ='"+image+"'");
			tag = true;
		}
		
		if(!tag){
			return null;
		}
		
		User user = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			pstm = conn.prepareStatement(find_sql.toString());
			
			rs = pstm.executeQuery();
			
			if(rs.next()){
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setRule(rs.getString("rule"));
			user.setRealname(rs.getString("realname"));
			user.setSex(rs.getString("sex"));
			
			City city = new City();
			city.setId(rs.getInt("city"));
			user.setCity(city);
			
			
			//certType
			CertType certType = new CertType();
			certType.setId(rs.getInt("cert_type"));
			user.setCertType(certType);
			
			user.setCert(rs.getString("cert"));
			user.setBirthday(rs.getDate("birthday"));
			
			//UserType
			UserType userType = new UserType();
			userType.setId(rs.getInt("user_type"));
			user.setUserType(userType);
			
			user.setContent(rs.getString("content"));
			user.setStatus(rs.getString("status"));
			user.setLoginIp(rs.getString("login_ip"));
			user.setImagePath(rs.getString("image_path"));
		}
		}
		finally{
			DBUtils.closeStatement(rs, pstm);
		}
		return user;
	}


	//登录验证信息
	@Override
	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		// SQL 语句
		String find_sql = "select * from t_user where username =? and password=?";
		
		User user = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			pstm = conn.prepareStatement(find_sql);
			pstm.setString(1, username);
			pstm.setString(2,password);
			
			rs = pstm.executeQuery();
			if(rs.next()){
			//解析结果查询结果集，并加以封装
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRule(rs.getString("rule"));
				user.setRealname(rs.getString("realname"));
				user.setSex(rs.getString("sex"));
				
				//City
				City city = new City();
				city.setId(rs.getInt("city"));
				user.setCity(city);
				
				
				//certType
				CertType certType = new CertType();
				certType.setId(rs.getInt("cert_type"));
				user.setCertType(certType);
				
				user.setCert(rs.getString("cert"));
				user.setBirthday(rs.getDate("birthday"));
				
				//UserType
				UserType userType = new UserType();
				userType.setId(rs.getInt("user_type"));
				user.setUserType(userType);
				
				user.setContent(rs.getString("content"));
				user.setStatus(rs.getString("status"));
				user.setLoginIp(rs.getString("login_ip"));
				user.setImagePath(rs.getString("image_path"));	
			}
		}finally{
			DBUtils.closeStatement(rs, pstm);
		}
		return user;
	}


	@Override
	public boolean updateUser(User one) throws SQLException {
		//SQL
		StringBuffer update_sql = new StringBuffer("update t_user set");
		
		//查询条件标识
		boolean tag = false;
		
		int id = one.getId();
		if(id == 0){
			return false;
		}else{
			update_sql.append(" id="+id);
		}
		
		//查询条件 password 
		String password = one.getPassword();
		if(password!=null && !password.isEmpty()){
			update_sql.append(",password="+"'+password+'");
			tag = true;
		}
		
		// 查询条件 username
		String username = one.getUsername();
		if(username!=null && !username.isEmpty()){
			update_sql.append(",username="+"'+username+'");
			tag = true;
		}
		
		//查询条件 Rule
		String rule = one.getRule();
		if(rule!=null && !rule.isEmpty()){
			update_sql.append(",rule="+"'+rule+'");
			tag = true;
		}
		
		//查询条件 realname
		String realname = one.getRealname();
		if(realname!=null && !realname.isEmpty()){
			update_sql.append(",realname="+"'+realname+'");
			tag = true;
		}
		
		//city
		if(one.getCity()!=null){
			int city = one.getCity().getId();
			if(city!=0){
				update_sql.append(",city="+city);
				tag = true;
			}
		}
		
		//certType
		if(one.getCertType()!=null){
			int cert_type = one.getCertType().getId();
			if(cert_type!=0){
				update_sql.append(",cert_type="+cert_type);
				tag = true;
			}
		}
		
		//cert
		String cert = one.getCert();
		if(cert!=null && !cert.isEmpty()){
			update_sql.append(",cert="+"'+cert+'");
			tag = true;
		}
		
		//userType
		if(one.getUserType()!=null){
			int userType = one.getUserType().getId();
			if(userType!=0){
				update_sql.append(",userType="+userType);
				tag = true;
			}
		}
		
		//content
		String content = one.getContent();
		if(content!=null && !content.isEmpty()){
			update_sql.append(",content="+"'+content+'");
			tag = true;
		}
		
		//statues
		String status = one.getStatus();
		if(status!=null && !status.isEmpty()){
			update_sql.append(",status="+"'+status+'");
			tag = true;
		}
		
		//loginip
		String ip = one.getLoginIp();
		if(ip!=null && !ip.isEmpty()){
			update_sql.append(",login_ip="+"'+ip+'");
			tag = true;
		}
		
		//imagepath
		String image = one.getImagePath();
		if(image!=null && !image.isEmpty()){
			update_sql.append(",image="+"'+image+'");
			tag = true;
		}
		
		update_sql.append("where id="+id);
		
		
		//没有查询条件
		if(!tag){
			return false;
		}
		
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(update_sql.toString());
			int row = pstmt.executeUpdate();
			if(row != 0){
				tag = true;
			}else{
				tag = false;
			}
		}finally{
			DBUtils.closeStatement(null, pstmt);
		}
		return tag;
	}

}
