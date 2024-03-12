package com.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@RequestMapping("/test1")
public class WishMessageController {
    @RequestMapping("/")
    //mapping is starts from "/" ;
    //request path handler method is case sensitive
    public String goToHome()
    {
	return "home";
    }
   // @RequestMapping("/report")
   //@RequestMapping(value="/REPORT",method=RequestMethod.POST)
    
    //@GetMapping("/REPORT")
    //if the mapping value is same is we can differentiate with the help of get and post methods
    //if request mapping and  mode is same it throws exception
    //at max it specifies two modes by defuault
    @GetMapping
    public String showReport1()
    {
	return "display";
    }
    //one handler method can have any number of request values
    @PostMapping(value={"/REPORT","/REPORT2","/REPORT3"})
    public String showReport2()
    {
	
	return "display2";
    }
}

   
    