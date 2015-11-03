package edu.csupomona.cs480.data;

import java.util.Date;


/**
 * The basic user object.
 */
public class User {

	private int no;
	/** The unique user Id */
    private String id;
    /** The unique user Id */
    private String pw;
    
    private String name;
    /** The unique user Id */
    private String major;
    /** The timestamp when the user is being created */
    private String creationTime = new Date(System.currentTimeMillis()).toString();
    
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
}
