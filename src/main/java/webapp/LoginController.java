package webapp;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	final static Logger logger = Logger.getLogger(LoginController.class);
	
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String showLoginPage(Locale locale) {
    	logger.debug("show login");
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLogoutPage(ModelMap model) {
    	logger.debug("show logout");
        model.put("errorMessage", "Logged out");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleUserLogin(@ModelAttribute("form") 
	@Valid FormDTO form, ModelMap model, @RequestParam String name,
            @RequestParam String password) {

    	logger.debug("handleUserLogin");
    	
        if (!loginService.validateUser(name, password)) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        model.put("name", name);
        return "welcome";
    }
//     @RequestMapping(value = "/welcome", method = RequestMethod.GET)
//     public String handleUserWelcomePage(ModelMap model, @RequestParam String name,
//             @RequestParam String email, @RequestParam String age) {

//     	logger.debug("handleUserWelcomePage");
    	
//     	logger.debug(name + " " + email);
//     	logger.debug(model.get(name) + " " + model.get(email));
//         model.put("name", name);
//         return "welcome";
//     }
    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String handleUserWelcomePage(@ModelAttribute("form") 
    		@Valid FormDTO form, BindingResult result,
    		ModelMap model, @RequestParam String name) {

    	logger.debug("handleUserWelcomePageForm");
        model.put("name", name);
        return "welcome";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String handleUserForm(Model model) {
    	logger.debug("handleUserFormPage");
    	model.addAttribute("form", new FormDTO()); 
        return "form";
    }
    
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String handleUserFormValidation(@ModelAttribute("form") 
    		@Valid FormDTO form, BindingResult result,
    		ModelMap model, @RequestParam String name,
            @RequestParam String email, @RequestParam int age) {

    	logger.debug("handleUserFormValidation");
        model.put("name", name);
        
        if (result.hasErrors()) {
            //formularz nie jest uzupełniony prawidłowo
            return "form";
        } else {
            //formularz wypełniony prawidłowo
        	return "welcome";
        }
        
    }
}
