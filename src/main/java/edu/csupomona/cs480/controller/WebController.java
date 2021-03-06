package edu.csupomona.cs480.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.ClassScraper;
import edu.csupomona.cs480.MD5;
import edu.csupomona.cs480.Message;
import edu.csupomona.cs480.MessageController;
import edu.csupomona.cs480.SmtpMailSender;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.provider.UserManager;


@RestController
public class WebController {

    @Autowired
    private UserManager userManager;
    @Autowired
    private SmtpMailSender smtp;

    
    @RequestMapping("/success/**")
    public ModelAndView check(HttpServletRequest request) throws SQLException{
    	
    	MessageController db = new MessageController();
    	Connection con = db.getConnection();
    	
    	String query = "UPDATE users SET enabled = 1 WHERE HASH = ?";
    	
    	
    	if(request.getRequestURI().length()>9){
    		String hash= request.getRequestURI().substring(9);
    		
    		PreparedStatement ps = con.prepareStatement(query);
    		ps.setString(1, hash);
    		
    		ps.executeUpdate();
    		
    		ModelAndView model = new ModelAndView("post-activation");
    		return model;
    	}
    	else return null;
    }
    
    
    /* This method lists all classes available */
    @RequestMapping(value = "/classes", method = RequestMethod.GET, produces = "application/JSON")
    String listAllClasses() {
    	ClassScraper cs = ClassScraper.getInstance();
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return mapper.writeValueAsString(cs.getClassNames());
    	} catch(IOException e) {
    		return null;
    	}
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    ModelAndView getLogin() {
        ModelAndView models = new ModelAndView("login");
        return models;
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    ModelAndView getRegister() {
        ModelAndView model = new ModelAndView("registration");
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    ModelAndView postRegister(@ModelAttribute("User") User user) throws SQLException, NoSuchAlgorithmException, MessagingException {
    	
    	MessageController db = new MessageController();
    	Connection con = db.getConnection();
    	
    	String email = user.getId();
    	String pw = user.getPw();
    	String hash = MD5.hash(email);
    	
    	String query = "INSERT INTO users(USER_ID, USER_PW, HASH) values(?, ?, ?)";
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setString(1, email);
    	pstmt.setString(2, pw);
    	pstmt.setString(3, hash);
    	pstmt.executeUpdate();
    	
    	String query2 = "INSERT INTO authorities(USER_ID, ROLE) values(?, ?)";
    	PreparedStatement pstmt2 = con.prepareStatement(query2);
    	pstmt2.setString(1, email);
    	pstmt2.setString(2, "ROLE_USER");
    	pstmt2.executeUpdate();
    	
    	smtp.sendMail(email);
        ModelAndView models = new ModelAndView("post-registration");
        return models;
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET, produces = "application/JSON")
    String getUsername() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
        	throw new Exception("Could not retrieve username");
        } else {
            return "{ \"name\": \"" + authentication.getName() + "\" }";	
        }
    }
    
    @RequestMapping(value = "/messages/{board}", method = RequestMethod.GET, produces = "application/JSON")
    String getMessages(@PathVariable("board") String board) throws Exception {
    	MessageController mc = new MessageController();
    	Connection con = mc.getConnection();
    	
    	String query = "SELECT * FROM messages where DEST = ?";
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setString(1, board);
    	ResultSet rs = pstmt.executeQuery();
    	
    	JSONArray jsonArray = new JSONArray();
    	
    	while(rs.next()) {
    		int total_rows = rs.getMetaData().getColumnCount();
    		JSONObject obj = new JSONObject();
    		for (int i = 0; i < total_rows; i++) {
    			obj.put(rs.getMetaData().getColumnLabel(i + 1)
    					.toLowerCase(), rs.getObject(i + 1));
    		}
    		jsonArray.put(obj);
    	}
    	return jsonArray.toString();
    }
   
}
