package com.xiao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiao.demo.dao.IBaseDao;
import com.xiao.demo.dao.IUserDao;
import com.xiao.demo.entity.UserInfo;

/**
 * 用户service类
 * <p>
 * ClassName: UserService
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: (c)2017 Jastar·Wang,All rights reserved.
 * </p>
 * 
 * @author Jastar·Wang
 * @date 2017年4月12日
 */
@Service
public class UserService extends BaseService<UserInfo> {

	@Autowired
	private IUserDao userDao;

	@Override
	protected IBaseDao<UserInfo> getDao() {
		return userDao;
	}

}