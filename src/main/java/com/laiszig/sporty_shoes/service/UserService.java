package com.laiszig.sporty_shoes.service;

import com.laiszig.sporty_shoes.entity.SecurityUser;
import com.laiszig.sporty_shoes.entity.User;
import com.laiszig.sporty_shoes.formData.CredentialFormData;
import com.laiszig.sporty_shoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsManager userDetailsManager;


    public List<User> getAll () {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        /**
        String password = user.getPassword();
        String encoded = passwordEncoder.encode(password);
        user.setPassword(encoded);
        user.setEnabled((short) 1);
        return userRepository.save(user);
         **/
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (user.getUsername().equals("admin")) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("USER"));
        }
        SecurityUser securityUser = new SecurityUser(
             user.getUsername(),
             passwordEncoder.encode(user.getPassword()),
             authorities,
             true
     );
        userDetailsManager.createUser(securityUser);
        return user;
    }

    public void updatePassword(CredentialFormData credentialFormData) {
        String encoded = passwordEncoder.encode(credentialFormData.getNewPassword());
        userDetailsManager.changePassword(credentialFormData.getOldPassword(), encoded);

    }
}
