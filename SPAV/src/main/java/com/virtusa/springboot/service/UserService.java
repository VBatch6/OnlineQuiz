package com.virtusa.springboot.service;


import org.springframework.security.core.userdetails.UserDetailsService;


import com.virtusa.springboot.model.User;
import com.virtusa.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);
	
	

}
