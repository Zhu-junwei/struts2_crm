package com.zhujunwei.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import com.zhujunwei.domain.User;
import com.zhujunwei.utils.HibernateUtils;

public class UserTest {
	
	@Test
	@SuppressWarnings("unchecked")
	//测试用户登录
	public void testLogin() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query<User> query = session.createQuery("from User where user_code = ?0 and user_password = ?1");
		query.setParameter(0, "aaa");
		query.setParameter(1, "111");
		List<User> list = query.list();
		if (list.size()>0) {
			System.out.println(list.get(0));
		}
		transaction.commit();
	}
}
