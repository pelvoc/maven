package example.controller;

import example.dao.ProfileRepository;
import example.dao.UserRepository;
import example.model.User;
import example.response.DefaultResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "myproject", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

	@Autowired
	private UserRepository userRepo;
        
        @Autowired
        private ProfileRepository profileRepo;
	
	@Data
	public static class SignupRequest {
		private String userName;
		private String password;
	}
	
	@RequestMapping(path = "signup", 
                        method = RequestMethod.POST, 
                        consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public DefaultResponse 
                signup(@RequestBody SignupRequest request) throws Exception {
		User user = userRepo.findByUserName(request.getUserName());
                if (user != null)
                        return new DefaultResponse(false, "User name exists.");
		userRepo.save(new User(request.getUserName(), request.getPassword()));
		return new DefaultResponse(true, null);
	}
                
        @Data
        public static class LoginRequest {
		private String userName;
		private String password;
	}
	
	@RequestMapping(path = "login", 
                        method = RequestMethod.POST, 
                        consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public DefaultResponse 
                login(@RequestBody LoginRequest request) throws Exception {
                User user = userRepo.findByUserName(request.getUserName());
                
                if(user==null)
                    return new DefaultResponse(false, "User does not exist.");
                
                if (request.getPassword().equals(user.getPassword()))
                        return new DefaultResponse(true, "Login success.");
                else
                        return new DefaultResponse(false, "Login failed.");
	}
                
}
