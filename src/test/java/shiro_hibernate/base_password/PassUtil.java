package shiro_hibernate.base_password;

import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

public class PassUtil {
	private String salt;
	/**
	 * salt
	 * @param password
	 * @return
	 */
	private String testRandom(String password) {
		SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
		randomNumberGenerator.setSeed(password.getBytes());
		return randomNumberGenerator.nextBytes().toHex();
	}
	
	/**
	 * 获取加密后的字节流
	 * @param password
	 * @return
	 */
	public byte[] setCodecSupport(String password){
		String str = testRandom(password);
		byte[] bytes = CodecSupport.toBytes(password+""+str, "utf-8");
		this.salt = str;
		return bytes;
	}
	
	/**
	 * 获取解密后的字符
	 * @param bytes
	 * @return
	 */
	public String getCodecSupport(byte[] bytes){
		String pasString = CodecSupport.toString(bytes, "utf-8");
		return pasString;
	}

	/**
	 * 获取盐
	 * @return
	 */
	public String getSalt() {
		return salt;
	}
	


}
