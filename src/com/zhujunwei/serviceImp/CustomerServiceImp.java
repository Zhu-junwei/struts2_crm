package com.zhujunwei.serviceImp;

import java.util.List;

import com.zhujunwei.dao.CustomerDao;
import com.zhujunwei.daoImp.CustomerDaoImp;
import com.zhujunwei.domain.Customer;
import com.zhujunwei.service.CustomerService;

public class CustomerServiceImp implements CustomerService {

	CustomerDao dao = new CustomerDaoImp();
	
	@Override
	public List<Customer> find() {
		return dao.find();
	}

	@Override
	public void save(Customer customer) {
		dao.save(customer);
	}

}
