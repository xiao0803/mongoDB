package com.xiao.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.xiao.demo.dao.IUserDao;
import com.xiao.demo.entity.UserInfo;

/**
 * 用户接口实现类
 * <p>
 * ClassName: UserDaoImpl
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
@Repository
public class UserDaoImpl extends BaseDaoImpl<UserInfo> implements IUserDao {

	@Override
	protected Class<UserInfo> getEntityClass() {
		return UserInfo.class;
	}

}