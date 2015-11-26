package edu.csupomona.cs480;

import java.util.Date;

public class Message implements MessageComponents {

    private String name;
    private String destination;
    private String message;
    private long time;
    
    public Message() {
    	Date d = new Date();
    	this.time = d.getTime();
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setDest(String destination) {
    	this.destination = destination;
    }
    
    public String getDestination() {
    	return destination;
    }
    
    public void setMessage(String message) {
    	this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setTime(long time){
    	this.time = time;
    }
    
    public long getTime() {
    	return time;
    }

}
