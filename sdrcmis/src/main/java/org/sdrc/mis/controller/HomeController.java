package org.sdrc.mis.controller;

import org.sdrc.mis.model.EmployeeModel;
import org.sdrc.mis.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@Controller
public class HomeController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@ResponseBody
	@RequestMapping(value={"/home","/"})
	public String home()
	{
		return "done";
	}
	
	
	@ResponseBody
	@RequestMapping("employee")
	public EmployeeModel employee()
	{
		return employeeDetailsService.findEmployeeByCode("1091");
	}
}
