package com.zhujunwei.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhujunwei.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断session中是否存在用户数据
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		//判断session中获取的用户信息是否为空
		if (existUser == null) {
			//没有登录
			//给出提示信息
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("没有登陆，没有权限访问!");
			//回到登录页面
			return Action.LOGIN;
		}
		//已经登录
		return invocation.invoke();
	}

}
