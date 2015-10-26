package edu.csupomona.cs480.data.bo;

import edu.csupomona.cs480.data.User;

public interface UserBoInterface {
	
	void save(User user);
	void update(User user);
	void delete(User user);
	User getUserById(String userID);
}