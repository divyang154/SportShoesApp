package mainapp.sportyshoesapp.web;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mainapp.sportyshoesapp.model.Category;
import mainapp.sportyshoesapp.model.User;
import mainapp.sportyshoesapp.repository.UserRepository;
import mainapp.sportyshoesapp.service.UserException;
import mainapp.sportyshoesapp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;

	@GetMapping({ "" })
	public String getLogin(ModelMap model) {
//		model.addAttribute("name", name);
//	 listOfStudents.stream().filter(ref -> ref.getStudentId() == id).findFirst().get();
		List<User> userList = userservice.getAllUsers().stream().filter(user -> user.getUserRole().equals("User"))
				.collect(Collectors.toList());
		model.put("userList", userList);
		return "manageusers";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String registerUser(Map<String, Object> map,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		map.put("error", "");
		return "registerUser";
	}

	@RequestMapping("/submitUser")
	public String saveUser(Map<String, Object> map, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("email") String email, HttpSession session) {
		User user = null;
		try {
			user = userservice.userCreateService(username, password, email, "User");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			map.put("error", "User already exists.Please enter new username");
			return "registerUser";
		}
		if (user != null) {
			session.setAttribute("loggedInUser", user);
		}
		return "manageusers";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/search")
	public String searchUser(ModelMap model, @RequestParam("userToBeSearched") String userToBeSearched) {

		List<User> listUsers = userservice.getSearchUser(userToBeSearched);
		if (listUsers.size() == 0) {
			model.put("error", "No User exist.Please enter valid name");
		} else {
			model.put("error", "");
			model.put("userList", listUsers);
		}
		return "manageusers";
	}

}
