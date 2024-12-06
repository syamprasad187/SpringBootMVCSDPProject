package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("adminhome")
	public ModelAndView adminhome() {
		
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("adminhome");
		
		long  count = adminService.empcount();
		mv.addObject("empcount", count);
		
		return mv;
	}
	
	@GetMapping("addcustomer")
	public String addcustomer(Model m) {
		m.addAttribute("customer", new Customer());
		return "addcustomer";  // addcustomer.jsp
	}
	
	@PostMapping("insertcustomer")
	public ModelAndView insertcustomer(@ModelAttribute("customer") Customer c) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customersuccess");
		
		String msg = adminService.addCustomer(c);
		mv.addObject("message", msg);
		
		return mv;
	}
	
	@GetMapping("adminlogin")
	public ModelAndView adminlogin() {
		
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}
	
	@PostMapping("checkadminlogin")
//	@ResponseBody
	public ModelAndView checkadminlogin(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		String auname = request.getParameter("auname");
		String apwd = request.getParameter("apwd");
		
		 Admin admin = adminService.checkadminlogin(auname, apwd);
		 
		 if(admin != null) {
			 // return "Successfully Logged In";
			 long  count = adminService.empcount();
			 mv.addObject("empcount", count);
			 
			 mv.setViewName("adminhome");
		 }
		 else {
			 // return "Login Failed";
			 mv.setViewName("adminloginfail");
			 mv.addObject("message", "Login Failed");
		 }
		 return mv;
		
	}
	
	@GetMapping("viewallemps")
    public ModelAndView viewallemps()
    {
      ModelAndView mv = new ModelAndView();
      List<Employee> emplist = adminService.ViewAllEmployees();
      mv.setViewName("viewallemps");
      mv.addObject("emplist",emplist);
      
      long  count = adminService.empcount();
      mv.addObject("empcount", count);
	
      return mv;
    }
	
	@GetMapping("updateempstatus")
    public ModelAndView updateempstatus()
    {
      ModelAndView mv = new ModelAndView();
      List<Employee> emplist = adminService.ViewAllEmployees();
      mv.setViewName("updateempstatus");
      mv.addObject("emplist",emplist);
      return mv;
    }
	
	@GetMapping("updatestatus")
	public String updatestatus( @RequestParam("status") String status, @RequestParam("id") int eid) {
		
		adminService.updateEmployeeStatus(status, eid);
		return "redirect:/updateempstatus";
	}
	
	@GetMapping("deleteemp")
    public ModelAndView deleteemp()
    {
      ModelAndView mv = new ModelAndView();
      List<Employee> emplist = adminService.ViewAllEmployees();
      mv.setViewName("deleteemp");
      mv.addObject("emplist",emplist);
      return mv;
    }
	
	@GetMapping("delete")
	public String deleteOperation( @RequestParam("id") int eid) {
		
		adminService.deleteemp(eid);
		return "redirect:/deleteemp"; // redirected to specific path
	}
	
	@GetMapping("adminlogout")
	public ModelAndView adminlogout() {
		
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}
}
