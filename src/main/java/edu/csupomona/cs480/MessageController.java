package edu.csupomona.cs480;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;



@Controller
public class MessageController {
	
	Connection dbConnection = null;
	String url = "jdbc:mysql://localhost:3306/broncoboard";
	String user = "root";
	String password = "4026";
	String driver = "com.mysql.jdbc.Driver";
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found.");
			e.printStackTrace();
		}
		
		try {
			dbConnection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database.");
			e.printStackTrace();
		}
		
		return dbConnection;
		
	}

    @MessageMapping("/send")
    @SendTo("/receive")
    public Message passMessage(Message message) throws Exception {
    	
    	String name = message.getName();
    	String destination = message.getDestination();
    	String content = message.getMessage();
    	long time = message.getTime();
    	
    	Connection con = getConnection();
    	String query = "IF NOT EXISTS (SELECT * FROM messages WHERE NAME = " + name + 
    				   "AND MESSAGE = " + message +
    				   "AND TIME = " + time +
    			       ") INSERT INTO messages(NAME, DEST, MESSAGE, TIME) values(?, ?, ?, ?)";
    	
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setString(1, name);
    	pstmt.setString(2, destination);
    	pstmt.setString(3, content);
    	pstmt.setLong(4, time);
    	
    	pstmt.executeUpdate();
    	
        return message;
    } 
}
