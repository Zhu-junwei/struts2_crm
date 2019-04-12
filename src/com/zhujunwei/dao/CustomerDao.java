package com.zhujunwei.dao;

import java.util.List;

import com.zhujunwei.domain.Customer;

public interface CustomerDao {
	
	public List<Customer> find();

	public void save(Customer customer);
}
