package com.example.impl;

import com.example.service.AdminService;
import org.springframework.stereotype.Service;


//@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public void register(String name, String password) {
		System.out.println("admin register1 : " + name + " ; " + password);
	}

	@Override
	public void login(String name, String password) {
		System.out.println("admin login1 : " + name + " ; " + password);
	}

}
