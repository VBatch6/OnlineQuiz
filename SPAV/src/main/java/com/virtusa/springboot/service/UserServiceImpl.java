package com.virtusa.springboot.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.virtusa.springboot.model.User;
import com.virtusa.springboot.repository.UserRepository;

import com.virtusa.springboot.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository =userRepository;
		
	}
	
   @Override
	public User save(UserRegistrationDto  registrationDto) {
    	User user=new User(registrationDto.getUsername(),registrationDto.getEmail(),
    			passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getRoles());
		System.out.println(registrationDto.getRoles());
    	return userRepository.save(user);
		
	}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=userRepository.findByUsername(username);
     if(user==null) {
    	 throw new UsernameNotFoundException("Invalid username or password");
     }
	
	//return user.map(MyUserDetails::new).get();
	return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
			Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
	
}





}
