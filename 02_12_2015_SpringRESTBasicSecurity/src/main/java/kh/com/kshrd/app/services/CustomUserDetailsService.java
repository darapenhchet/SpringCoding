package kh.com.kshrd.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kh.com.kshrd.app.entities.Role;
import kh.com.kshrd.app.entities.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	@Qualifier("userServiceAPI")
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByUsername(username);
		System.out.println("User : " + user);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getStatus().equals("1"), true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(user.getRoles().size());
		try{
			for (Role role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
				System.out.println(role.getName());
			}
			//authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			//System.out.print("authorities :" + authorities);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return authorities;
	}
}
