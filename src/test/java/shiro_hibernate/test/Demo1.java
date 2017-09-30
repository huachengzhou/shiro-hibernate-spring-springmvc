package shiro_hibernate.test;

import java.util.UUID;

public class Demo1 {
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString().substring(0, 15);
		System.out.println(uuid);
	}
}
