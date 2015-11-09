package edu.csupomona.cs480.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.ClassScraper;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.provider.UserManager;


@RestController
public class WebController {

    @Autowired
    private UserManager userManager;


    /* This method lists all classes available */
    @RequestMapping(value = "/classes", method = RequestMethod.GET, produces = "application/JSON")
    String listAllClasses() {
    	ClassScraper cs = new ClassScraper();
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return mapper.writeValueAsString(cs.getClassNames());
    	} catch(IOException e) {
    		return null;
    	}
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    ModelAndView getHelp() {
        ModelAndView models = new ModelAndView("login");
        return models;
    }
    
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    ModelAndView getChat() {
        ModelAndView models = new ModelAndView("chat");
        return models;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    ModelAndView getSample() {
        ModelAndView model = new ModelAndView("registration");
        return model;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    ModelAndView getTest() {
        ModelAndView model = new ModelAndView("success");
        return model;
    }
}
