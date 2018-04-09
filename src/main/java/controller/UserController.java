package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Response.SignupResponse;
import dao.UserRepository;
import lombok.Data;
import model.User;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Data
	public static class SignupRequest {
		private String userName;
		private String password;
	}
	
	@RequestMapping("/myproject/signup")
	@ResponseBody
	public SignupResponse signup(@RequestBody SignupRequest request) {
		userRepo.findByUserName(userName);
		userRepo.save(new User(request.getUserName(), request.getPassword()));
		return new SignupResponse(true, null);
	}
}
