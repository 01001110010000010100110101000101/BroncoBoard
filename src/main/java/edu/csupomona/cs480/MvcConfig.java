package edu.csupomona.cs480;
//This manages what certain pages will be used when we try to go to that page
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        //Change set view name to the success registration page
        registry.addViewController("/success/**").setViewName("sucess");
    }

}
