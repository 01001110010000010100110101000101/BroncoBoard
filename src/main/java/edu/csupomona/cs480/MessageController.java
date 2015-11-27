package edu.csupomona.cs480;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    	
    	String query = "SELECT * FROM messages where DEST = ? AND NAME = ? AND TIME = ? AND MESSAGE = ?";
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setString(1, destination);
    	pstmt.setString(2, name);
    	pstmt.setString(3, Double.toString(time));
    	pstmt.setString(4, content);
    	ResultSet rs = pstmt.executeQuery();
    	
    	if(!rs.next()) {
            query = "INSERT INTO messages(NAME, DEST, MESSAGE, TIME) values(?, ?, ?, ?)";
            
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, destination);
            pstmt.setString(3, content);
            pstmt.setLong(4, time);
            
            pstmt.executeUpdate();
    	}
    	
        return message;
    } 
}
