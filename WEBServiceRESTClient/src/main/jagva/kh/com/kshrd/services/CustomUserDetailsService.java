package kh.com.kshrd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kh.com.kshrd.entities.Role;
import kh.com.kshrd.entities.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
		
		if(user==null){
			throw new UsernameNotFoundException("Username Not Found");
		}
		return new org.springframework.security.core.userdetails.User
				(user.getUsername(), 
				 user.getPassword(), 
				 user.getStatus().equals("1"), 
				 true, 
				 true, 
				 true, 
				 getGrantedAuthorities(user));
		
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		try{
			for (Role role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
				System.out.println(role.getName());
			}
			System.out.print("authorities :" + authorities);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return authorities;
	}

}
