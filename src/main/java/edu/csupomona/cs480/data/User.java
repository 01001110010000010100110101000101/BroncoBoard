package edu.csupomona.cs480.data;

import java.util.Date;


/**
 * The basic user object.
 */
public class User {

	/** The unique user Id */
	private int no;
    private String id;
    private String pw;
    private String role;
    /** The timestamp when the user is being created */
    private String creationTime = new Date(System.currentTimeMillis()).toString();
    
    public User() {}
    
    public User(String id, String pw) {
    	this.id = id;
    	this.pw = pw;
    }
    
    public int getNo(){
    	return no;
    }
    
    public void setNo(int no){
    	this.no = no;
    }
    
    public String getPw(){
    	return pw;
    }
    
    public void setPw(String pw){
    	this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String major) {
		this.role = major;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
}
