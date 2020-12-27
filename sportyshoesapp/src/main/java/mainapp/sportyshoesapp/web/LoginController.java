package mainapp.sportyshoesapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mainapp.sportyshoesapp.model.User;
import mainapp.sportyshoesapp.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userservice;

	@GetMapping({ "" })
	public String getLogin(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
//		model.addAttribute("name", name);
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/authenticate")
	public String authenticateUser(ModelMap model, @RequestParam("username") String username,
			@RequestParam("password") String password,HttpSession session) {

		String error = "";
		User user = null;
		if (username == null || username.length() <= 0) {
			error = "Username cannot be blank";
			model.put("error", error);
			return "login";

		} else if (password == null || password.length() <= 0) {
			error = "Password cannot be blank";
			model.put("error", error);
			return "login";

		} else {

			user = userservice.getUserService(username);
			if (!user.getPassword().equals(password)) {
				error = "Password is incorrect.Please enter correct password";
				model.put("error", error);
				return "login";
			} else {
				session.setAttribute("loggedInUser", user);
				if (user.getUserRole().equals("Administrator")) {
					return "AdminPanel";
				}

				else {
					return "UserPanel";
				}
			}

		}
	}

}