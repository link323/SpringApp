package webapp;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String handleUserForm(@ModelAttribute("form") 
    		@Valid FormDTO form, BindingResult result,
    		ModelMap model, @RequestParam String name,
            @RequestParam String email, @RequestParam String age) {

    	logger.debug("handleUserWelcomePageForm");
//     	if (result.hasErrors()) {
//             System.out.println("has Errors");
//         } else {
//             return "form is ok";
//         }
    	logger.debug(name + " " + email);
    	logger.debug(model.get(name) + " " + model.get(email));
        model.put("name", name);
        return "welcome";
    }
}
