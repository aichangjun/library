package test;

import dao.impl.UserDaoImpl;
import entity.User;

public class Test {
	@org.junit.Test
	public void test() {
		User u= new User(4,"aaa","111");
		UserDaoImpl ud=new UserDaoImpl();
		System.out.println(ud.queryOne(u));
                System.out.println("小猪");
	}
}
