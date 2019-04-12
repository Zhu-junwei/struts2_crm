package com.zhujunwei.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate 工具类
 * @author zhujunwei
 * 2019年3月18日 下午5:52:57
 */
public class HibernateUtils {
	
	private static final Configuration CONFIGURATION ;
	private static final SessionFactory SESSION_FACTORY ;
	
	static {
		CONFIGURATION = new Configuration().configure();
		SESSION_FACTORY = CONFIGURATION.buildSessionFactory();
	}
	
	/**
	 *   取得Session对象
	 * @return
	 */
	public static Session openSession() {
		return SESSION_FACTORY.openSession();
	}
	
	public static Session getCurrentSession() {
		return SESSION_FACTORY.getCurrentSession();
	}
}
