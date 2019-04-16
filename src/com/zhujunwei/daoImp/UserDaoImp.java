package com.zhujunwei.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.zhujunwei.dao.UserDao;
import com.zhujunwei.domain.User;
import com.zhujunwei.utils.HibernateUtils;

public class UserDaoImp implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	//用户登录
	public User login(User user) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query<User> query = session.createQuery("from User where user_code = ?0 and user_password = ?1");
		query.setParameter(0, user.getUser_code());
		query.setParameter(1, user.getUser_password());
		List<User> list = query.list();
		if (list.size()>0) {
			return list.get(0);
		}
		transaction.commit();
		return null;
	}

}
