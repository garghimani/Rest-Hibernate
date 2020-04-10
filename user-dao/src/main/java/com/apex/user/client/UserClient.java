package com.apex.user.client;

import com.apex.user.dao.UserDAO;
import com.apex.user.vo.UserVO;

public class UserClient {

	public static void main(String[] args) {

		UserDAO userDAO = new UserDAO();
		UserVO user = new UserVO();

		user.setFirstName("ABC");
		user.setLastName("XYZ");
		user.setMiddleName("G");

		userDAO.createUser(user);

		/*
		 * UserVO user1 = userDAO.getUser(8); user1.setMiddleName("G");
		 * 
		 * userDAO.updateUser(user1);
		 * 
		 * userDAO.deleteUser(9);
		 */

	}
}
