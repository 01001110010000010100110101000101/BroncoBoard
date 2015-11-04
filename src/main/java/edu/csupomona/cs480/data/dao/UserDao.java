package edu.csupomona.cs480.data.dao;

import java.util.List;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.dao.UserDaoInterface;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



/**
 * User Data Access Object (DAO)
 * @author Sang Choi
 */
public class UserDao extends HibernateDaoSupport implements UserDaoInterface {

	public void save(User user) {
		getHibernateTemplate().save(user);
		
	}

	public void update(User user) {
		getHibernateTemplate().update(user);
		
	}

	public void delete(User user) {
		getHibernateTemplate().delete(user);
		
	}

	public User getUserById(String userID) {
		List list = getHibernateTemplate().find("from User where id=?", userID);
		
		if (list.isEmpty())
			return null;
		
		return (User)list.get(0);
	}

}