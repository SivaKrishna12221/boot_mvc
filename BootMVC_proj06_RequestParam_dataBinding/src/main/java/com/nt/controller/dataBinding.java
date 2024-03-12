package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class dataBinding {

	/*
	 * @GetMapping("/data") public String bindData(Map<String, Object>
	 * map, @RequestParam("sno") int no, @RequestParam("sname") String name) {
	 * System.out.println("number:" + no + ",,Name:" + name); return "result"; }
	 */

	// if the param attribute are not given the url name and data types name should
	// be same
	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam int sno, @RequestParam String sname) {
		System.out.println("number:" + sno + ",,Name:" + sname);
		return "result";
	}*/
	// 3)If the requset param of @annotation is not specified in the uri it will
	// throws exception
	// solution for that one is keep @RequestParam is required false (by default it
	// is true)
	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam int sno,
			@RequestParam(required = false) String sname) {
		System.out.println("number:" + sno + ",,Name:" + sname);
		return "result";
	}*/

	// 4) if we don't give value to the request param through uri path ..if we don't
	// want to get Exception create default values
	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam int sno,
			@RequestParam(defaultValue = "raja") String sname) {
		System.out.println("number:" + sno + ",,Name:" + sname);
		return "result";
	}
	*/
	// 5)If our handler method request parameter type is non-string type.if you send
	// string type data in the uri it will generate exception .
	// 6) If we don't give the values to the uri ..it will generate exception
	// in order to over come
	// this specify default values...
	// solution 2.make it as a wrapper type and make optional request param
	//
	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam(defaultValue = "10") int sno,
			@RequestParam(defaultValue = "raja") String sname) {
		System.out.println("number:" + sno + ",,Name:" + sname);
		return "result";
	}*/
	// solution two for non string types passing uri values
	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam(required = false) int sno,
			@RequestParam(defaultValue = "raja") String sname) {
		System.out.println("number:" + sno + ",,Name:" + sname);
		return "result";
	}*/
	// 7)If one request parameter passing some values we can store it using string
	// arrays and list
	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam(defaultValue = "10") int sno,
			@RequestParam(defaultValue = "raja") String[] sname, @RequestParam("sname") List<String> names)
	{
		System.out.println("number:" + sno + ",,Name:" + Arrays.toString(sname) + " List of names:" + names);
		return "result";
	}*/
	// If the handler method or RequestParameter type is string if we pass multiple
	// values it take the values seperated by comma
	@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam(defaultValue = "10") int sno,
			@RequestParam(defaultValue = "raja") String sname) {
		System.out.println("number:" + sno + "sname:" + sname);
		return "result";
	}
}
