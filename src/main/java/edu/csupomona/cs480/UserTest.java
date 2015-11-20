package edu.csupomona.cs480;

public class UserTest {

	// Sang Choi A9
	// Interface Segregation Principle
}

interface User {
	public void login();
	public void logout();
}

interface Admin {
	public void addUser();
	public void banUser();
	public void callUser();
	public void changeUser();
}

class NormalUser implements User {

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	
}

class Manager implements User, Admin {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void banUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void callUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	
}