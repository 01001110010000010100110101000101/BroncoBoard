package edu.csupomona.cs480.data.bo;

import edu.csupomona.cs480.data.bo.UserBoInterface;
import edu.csupomona.cs480.data.dao.UserDao;
import edu.csupomona.cs480.data.User;

/**
 * User business object (BO)
 * @author Sang Choi
 */
public class UserBo implements UserBoInterface {
	
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save(User user) {
		userDao.save(user);
		
	}

	public void update(User user) {
		userDao.update(user);
		
	}

	public void delete(User user) {
		userDao.delete(user);
		
	}

	public User getUserById(String userID) {
		return userDao.getUserById(userID);
	}
	

}
