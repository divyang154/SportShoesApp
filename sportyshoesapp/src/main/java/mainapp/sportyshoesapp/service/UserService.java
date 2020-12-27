package mainapp.sportyshoesapp.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainapp.sportyshoesapp.model.User;
import mainapp.sportyshoesapp.repository.CategoryRepository;
import mainapp.sportyshoesapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepository;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public User userCreateService(String username, String password, String email, String role) throws UserException {
		User user = new User();
		user.setUsername(username);
		User newUser = null;
		List<User> userList = null;
		List<User> newUserList = null;
		userList = userrepository.findAll();
		for (User userCheck : userList) {
			if (userCheck.getUsername().equals(username.trim())) {
				throw new UserException("User already exists with entered username please enter new username");
			}
		}
		user.setPassword(password);
		user.setUserEmail(email);
		user.setCreatedOn(new Date());
		user.setUpdatedOn(new Date());
		user.setUserRole(role);
		userrepository.save(user);
		return user;
	}

	public List<User> getAllUsers() {

		return userrepository.findAll();
	}

	public List<User> getSearchUser(String searchString) {

		return userrepository.findAll().stream()
				.filter(value -> (value.getUsername().contains(searchString) && value.getUserRole().equals("User")))
				.collect(Collectors.toList());
	}

	public User getUserService(String username) {
		return userrepository.findAll().stream().filter(value -> value.getUsername().equals(username)).findFirst().get();
		
	}
//	
//	public void updateUser(Integer userId,String username,String password,String email,String role) {
//		User user=userDao.getUser(username);
//		user.setPassword(password);
//		user.setUserEmail(email);
//		user.setUserRole(role);
//		user.setUpdatedOn(new Date());
//		user.setUpdatedBy(userId);
//		userDao.updateUser(user);
//	}

}
