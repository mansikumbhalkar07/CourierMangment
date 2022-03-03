package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.UserDtls;
import com.example.demo.repository.UserRepository;

public class CustomerUserDtlsService  implements UserDetailsService{
	
	@Autowired
    private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			
			UserDtls u= repo.findByEmail(em);
			if(u==null)
			{
			  throw new  UsernameNotFoundException("No User");
			  
			}else {
				return new CustomUserDtls(u);
			}
			
		}catch(Exception e) {
			
		}
		return null;
		
		
	}
	
	
	
	
	

}
