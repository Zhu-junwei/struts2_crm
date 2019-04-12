package com.zhujunwei.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhujunwei.domain.Customer;
import com.zhujunwei.service.CustomerService;
import com.zhujunwei.serviceImp.CustomerServiceImp;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = 1L;
	Customer customer = new Customer();
	CustomerService service = new CustomerServiceImp();
	
	@Override
	public Customer getModel() {
		return customer;
	}
	
	public String find() {
		List<Customer> list = service.find();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findSuccess" ;
	}

	public String saveUI() {
		return "saveUI" ;
	}
	public String save() {
		service.save(customer);
		return "saveSuccess" ;
	}

	

}
