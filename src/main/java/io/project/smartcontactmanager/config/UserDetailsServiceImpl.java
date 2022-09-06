package io.project.smartcontactmanager.config;

import io.project.smartcontactmanager.model.User;
import io.project.smartcontactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       fetching user by DB

        User user = userRepository.getUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Could not found user!!!");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return customUserDetails;
    }
}
