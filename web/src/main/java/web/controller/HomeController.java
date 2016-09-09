package web.controller;

import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView  greeting(){
		//return "welcome";
		 return new ModelAndView("welcome", "command", new Student());
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")Student student, HttpServletRequest req, 
	   ModelMap model) throws Exception {
		req.setCharacterEncoding( "UTF-8" );
	      model.addAttribute("name", student.getName());
	      model.addAttribute("age", student.getAge());
	      model.addAttribute("id", student.getId());
	      
	      System.out.println(req.getCharacterEncoding());
	      
	      
	      
	      
	      Enumeration<String> e = req.getParameterNames();
	      while(e.hasMoreElements()){
	    	  String name = e.nextElement();
	    	  System.out.println(req.getParameter(name));
	    	  String value = req.getParameter(name);
	    	  
	    	  byte[] bytes = value.getBytes(StandardCharsets.ISO_8859_1);
	    	  String item = new String(bytes, StandardCharsets.UTF_8);
	    	  
	    	  System.out.println(item);
	      }
	      
	      return "result";
	   }
}
