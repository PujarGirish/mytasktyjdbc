package com.ty.userap.controller;

import com.ty.userapp.dao.UserDao;
import com.ty.userapp.dto.User;

public class UserController {
	public static void main(String[] args) {
		User user = new User();
		user.setId(7);
		user.setName("Inchara");
		user.setEmail("icnchi@gmail.com");
		user.setPassword("inchi@123");
		UserDao us = new UserDao();
		// us.Saveuser(user);

		us.fetchallusersdata();
		us.FindByUserFindByEmail("giriss", "54556");
	}
}
