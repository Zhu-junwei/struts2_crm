package com.zhujunwei.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhujunwei.domain.Customer;
import com.zhujunwei.service.CustomerService;
import com.zhujunwei.serviceImp.CustomerServiceImp;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = 1L;
	Customer customer = new Customer();
	CustomerService service = new CustomerServiceImp();
	
	
	
	//查询所有客户
	public String find() {
		List<Customer> list = service.find();
		
		//存数据。
		//方法一：存到request
//		ServletActionContext.getRequest().setAttribute("list", list);
		//方法二：存到ValueStack
		ActionContext.getContext().getValueStack().set("list", list);
		return "findSuccess" ;
	}
	
	//保存客户
	public String saveUI() {
		return "saveUI" ;
	}
	public String save() {
		service.save(customer);
		return "saveSuccess" ;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

}
