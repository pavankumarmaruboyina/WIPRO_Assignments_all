package com.example.portfolio_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	 	@GetMapping("/")
	    public String showHomePage() {
	        return "home"; // This will map to /WEB-INF/home.html
	    }
	    @GetMapping("/about")
	    public String showAboutPage() {
	        return "about"; // Resolves to /WEB-INF/test.html
	    }
	    @GetMapping("/education")
	    public String showEducationPage() {
	        return "education"; // Resolves to /WEB-INF/test.html
	    }
	    @GetMapping("/skills")
		public String showSkillsPage() {
		        return "skills"; // Resolves to /WEB-INF/test.html
	    }
	    @GetMapping("/contact")
	    public String showContactPage() {
			       return "contact"; // Resolves to /WEB-INF/test.html
			    

}
}
