package com.example.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.example.service.UserService;
import org.springframework.stereotype.Service;


/**
 * 不考虑dubbo的任何问题. 正常开发
 * 只考虑spring管理的问题.
 * spring容器管理服务对象. 
 * 1. bean标签管理
 * 2. 注解管理
 *  使用注解管理, 容易导包错误. Dubbo也提供了service注解. 但是dubbo的service注解
 *  有代码冲突. 在大多数情况下. 和spring-context, spring-tx有冲突.
 *  Dubbo的service注解, 在2.5.3版本中(使用spring2.5)注解无冲突.
 */

@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {

	@Override
	public void register(String name, String password) {
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			
		}
		System.out.println("user register1 : " + name + " ; " + password);
	}

	@Override
	public String login(String name, String password) {
		System.out.println("user login1 : " + name + " ; " + password);
		return RpcContext.getContext().getLocalAddress().toString();
	}

}
