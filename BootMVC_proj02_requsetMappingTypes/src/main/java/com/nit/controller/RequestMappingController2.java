package com.nit.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingController2 {
 
    @Autowired
    private ServletContext context;
    @Autowired
    private ServletConfig config;
    @Autowired
    private HttpSession session;
   @RequestMapping("/")
   public String goToHome()
   {
       return "home";
   }
   @RequestMapping("/info")
   public String showReport1()
   {
       System.out.println("we can get application name:"+context.getContextPath());
       System.out.println("Ds logical name:"+config.getServletName());
       System.out.println("we can get session id:"+session.getId());
       return "display1";	
   }
}
