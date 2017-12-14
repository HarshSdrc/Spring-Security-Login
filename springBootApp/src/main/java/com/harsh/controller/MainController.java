package com.harsh.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harsh.UserAuthenticationProvider;
import com.harsh.domain.Employee;
import com.harsh.model.EmployeeModel;
import com.harsh.service.EmployeeService;
import com.harsh.util.UserValidator;

@Controller
public class MainController {
	

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private  UserAuthenticationProvider userAuthenticationProvider;
	
	@RequestMapping({"/Students"})
	@ResponseBody
	List<EmployeeModel> home()
	{
		List<EmployeeModel> employee=employeeService.getAll();
		return employee;
		
	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	String login(@ModelAttribute("userForm") Employee userForm,Model model)
	{
		   try
	        {
			   UserDetails userDetails=employeeService.loadByUserName(userForm.getEmailId());
			   userAuthenticationProvider.additionalAuthenticationChecks(userDetails,new UsernamePasswordAuthenticationToken(userForm.getEmailId(),userForm.getPassword(),userDetails.getAuthorities()));
	        	return "home";
	        }
	        
	        catch(Exception e)
	        {
	        	  model.addAttribute("error", "Your username and password is invalid.");
	        	  return "login";
	        }
	}
	
	   @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	    public String welcome(Model model) {
	        return "home";
	    }
	
	
	 
	    @RequestMapping(value = "/registration", method = RequestMethod.GET)
	    public String registration(Model model) {
	        model.addAttribute("userForm", new Employee());

	        return "Register";
	    }
	    
	    
	    @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public String registration(@ModelAttribute("userForm") Employee userForm, BindingResult bindingResult, Model model) {
	        userValidator.validate(userForm, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return "Register";
	        }

	        employeeService.saveEmployee(userForm.getFirstName(), userForm.getLastName(), userForm.getEmailId(), userForm.getPassword());

	        try
	        {
	        userAuthenticationProvider.additionalAuthenticationChecks(employeeService.loadByUserName(userForm.getEmailId()),new UsernamePasswordAuthenticationToken(userForm.getEmailId(),userForm.getPassword()));
	        return "home";
	        }
	        
	        catch(Exception e)
	        {
	        	 model.addAttribute("error", "Your username and password is invalid.");
	        	return "login";
	        }
	    
	    }
	    
	    
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");
	        model.addAttribute("userForm", new Employee());
	        return "login";
	    }
	    
	    

	
}
