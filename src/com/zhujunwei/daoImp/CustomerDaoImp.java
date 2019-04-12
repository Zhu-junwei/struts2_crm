package com.zhujunwei.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.zhujunwei.dao.CustomerDao;
import com.zhujunwei.domain.Customer;
import com.zhujunwei.utils.HibernateUtils;

public class CustomerDaoImp implements CustomerDao {

	@SuppressWarnings("unchecked")
	@Override
	//查询客户列表
	public List<Customer> find() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query<Customer> query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		
		transaction.commit();
		return list;
	}

	@Override
	//保存客户
	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(customer);
		
		transaction.commit();
	}

}
