package at.danicoz.util;

import java.security.MessageDigest;

public class MD5Utils {

	public final static String md5(String s){
		
		//数据库 USER 表中密码字段使用的字符
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		
		try{
			byte[] btinput = s.getBytes();
			//使用 Java 的 MessageDigest 类创建一个 MD5 的对象
			MessageDigest mdinst = MessageDigest.getInstance("MD5");
			mdinst.update(btinput);
			
			//生成新的 MD5 字节数组
			byte[] md = mdinst.digest();
			
			int j = md.length;
			char str[] = new char[j*2];
			int k = 0;
			
			//计算 MD5 算法的计算步骤
			for(int i = 0;i<j;i++){
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0>>>4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			
			return new String(str);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
}
