package shiro_hibernate.base_password;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.UUID;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.junit.Assert;
import org.junit.Test;

public class AESDemo {
	
	@Test
	public void isit() throws UnsupportedEncodingException{
		AesCipherService aesCipherService = new AesCipherService();
		aesCipherService.setKeySize(128); //设置 key 长度
		//生成 key
		Key key = aesCipherService.generateNewKey();
		String text = "hello";
		//加密
		String encrptText = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
		//解密
		String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());
		System.out.println("key:"+new String(key.getEncoded(),"ISO8859-1").toString());
		System.out.println("加密之后:"+encrptText);
		System.out.println("解密之后:"+text2);
		Assert.assertEquals(text, text2);
	}
	
	@Test
	public void uuidKey(){
		String password = "123456";
		AesCipherService aesCipherService = new AesCipherService();
		aesCipherService.setKeySize(15); //设置 key 长度
		//key
		byte[] bs = UUID.randomUUID().toString().substring(0,15).getBytes();
		//加密 
		String encrptText = aesCipherService.encrypt(password.getBytes(),bs).toHex();
		//解密
		String pass = new String(aesCipherService.decrypt(Hex.decode(encrptText),bs).getBytes());
		boolean flag = pass.equals(password);
		System.out.println("password:"+password);
		System.out.println("pass:"+pass);
		System.out.println(flag?"yes":"no");
	}
}
