package com.zhujunwei.service;

import java.util.List;

import com.zhujunwei.domain.Customer;

public interface CustomerService {
	public List<Customer> find();

	public void save(Customer customer);
}
