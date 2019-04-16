package com.zhujunwei.serviceImp;

import com.zhujunwei.dao.UserDao;
import com.zhujunwei.daoImp.UserDaoImp;
import com.zhujunwei.domain.User;
import com.zhujunwei.service.UserService;

public class UserServiceImp implements UserService {
	
	UserDao dao = new UserDaoImp(); 

	@Override
	public User login(User user) {
		return dao.login(user);
	}

}
