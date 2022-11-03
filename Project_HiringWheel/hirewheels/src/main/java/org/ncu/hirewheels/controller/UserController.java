package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entites.LoginUser;
import org.ncu.hirewheels.entites.User;
import org.ncu.hirewheels.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

//@ResponseBody + @Controller eliminates the need to annotate every requesthandling method of the controller class with RespoeBody

@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody LoginUser loguser) {
		String email = loguser.getEmail();
		String password = loguser.getPassword();

		userService.getUserByEmail(email, password);

		return new ResponseEntity<User>(userService.getUserByEmail(email, password), HttpStatus.OK);

	}

}
