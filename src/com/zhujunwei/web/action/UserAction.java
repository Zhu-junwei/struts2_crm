package com.zhujunwei.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhujunwei.domain.User;
import com.zhujunwei.service.UserService;
import com.zhujunwei.serviceImp.UserServiceImp;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImp();

	//接受数据
	private User user = new User();
	
	/**
	 * 用户登录的方法
	 * @return
	 */
	public String login() {
		System.out.println(user);
		User existUser = service.login(user);
		//根据结果页面跳转
		if (existUser==null) {
			//登录失败
			//ActionError FieldError ActionMessage
			this.addActionError("用户名或密码错误");
			return LOGIN ;
		}else {
			//登录成功
//			ActionContext.getContext().getSession().put("existUser", existUser);
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return SUCCESS;
		}
	}

	@Override
	public User getModel() {
		return user;
	}

}
