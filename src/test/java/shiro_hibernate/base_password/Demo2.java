package shiro_hibernate.base_password;

import com.blake.common.Base64UU;

public class Demo2 {
	public static void main(String[] args) {
		String password = "123456";
		String salt = "d3af43eb-cde9-41c905g";
		password = Base64UU.setString(password+""+salt);
		System.out.println(password);
		String pass = Base64UU.getString("MTIzNDU2ZDNhZjQzZWItY2RlOS00MWM5MDVn");
		System.out.println(pass);
		
		pass = pass.substring(0,pass.lastIndexOf(salt));
		System.out.println(pass);
	}
}
