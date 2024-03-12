package com.nit.controller;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.service.IWishService;

@Controller
public class WishMessageController {
    @Autowired
    private IWishService service;

    @RequestMapping("/")
    public String showHomePage() {
	return "home";
    }

    @RequestMapping("/home")
    public String goToHome() {
	return "home";
    }

    /*
     * @RequestMapping("/wish")
     * public ModelAndView generateWish() {
     * String result = service.wishMessageGenerator();
     * return new ModelAndView("display", "wSmg", result);
     * }
     */
    /*
     * @RequestMapping("/wish")
     * public ModelAndView generateWishMessage()
     * {
     * String result= service.wishMessageGenerator();
     * ModelAndView mav= new ModelAndView();
     * mav.addObject("wSmg",result);
     * mav.setViewName("display");
     * return mav;
     * }
     */

    /*
     * @RequestMapping("/wish")
     * public String generateWishMessage(BindingAwareModelMap map)
     * {
     * String result=service.wishMessageGenerator();
     * map.addAttribute("wSmg",result);
     * return "display";
     * }
     */
    /*
     * @RequestMapping("/wish")
     * public String generateWishMessage(ModelMap map)
     * {
     * String result=service.wishMessageGenerator();
     * LocalDateTime ldt=service.generateWishTime();
     * map.put("wSmg", result);
     * map.put("time", ldt);
     * return "display";
     * }
     */
    /*
     * @RequestMapping("/wish")
     * public String generateWishMessage(HashMap<String, Object> map) {
     * String result = service.wishMessageGenerator();
     * LocalDateTime ldt = service.generateWishTime();
     * map.put("wSmg", result);
     * map.put("time", ldt);
     * return "display";
     * }
     */
    /*
     * @RequestMapping("/wish")
     * public String generateWishMessage(Map<String,Object> map)
     * {
     * String result=service.wishMessageGenerator();
     * LocalDateTime ldt=service.generateWishTime();
     * map.put("wSmg", result);
     * map.put("time", ldt);
     * return "display";
     * }
     */
    // @RequestMapping("/wish")
    /*
     * public Model generateWishMessage()
     * {
     * String result=service.wishMessageGenerator();
     * LocalDateTime ldt=service.generateWishTime();
     * Model model= new ExtendedModelMap();
     * model.addAttribute("wSmg", result);
     * model.addAttribute("time",ldt);
     * return model;
     * }///it is bad practice we should the objcet creating for this class
     * ds generated BindingAwareModelmap object wasted
     * it doesn't specifiyin the mapping .view resolver comp should take external
     * requst path
     */
    /*
     * @RequestMapping("/wish")
     * public void generateWishMessage(Model model)
     * {
     * String result=service.wishMessageGenerator();
     * LocalDateTime ldt=service.generateWishTime();
     * model.addAttribute("wSmg", result);
     * model.addAttribute("time",ldt);
     * }
     */

    // we can pass the output the browser directly without using viewresolver
    // component
    @RequestMapping("/wish")
    public void generateWishMessage(HttpServletResponse response) throws Exception {
	String result = service.wishMessageGenerator();
	LocalDateTime ldt = service.generateWishTime();
	PrintWriter pw = response.getWriter();
	// response.setContentType("html/text");
	pw.println("wish message is:" + result);
	pw.println("Now the time is:" + ldt);
    }
}
