package edu.csupomona.cs480.data.dao;

import edu.csupomona.cs480.data.User;


public interface UserDaoInterface {
	
	void save(User user);
	void update(User user);
	void delete(User user);
	User getUserById(String userID);

}
