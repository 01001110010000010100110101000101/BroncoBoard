package edu.csupomona.cs480;

import java.util.Date;

public class Message {

    private String name;
    private String destination;
    private String message;
    private long time;
    
    public Message() {
    	Date d = new Date();
    	this.time = d.getTime();
    }
    
    public String getName() {
        return name;
    }
    
    public String getDestination() {
    	return destination;
    }
    
    public String getMessage() {
        return message;
    }
    
    public long getTime() {
    	return time;
    }

}
