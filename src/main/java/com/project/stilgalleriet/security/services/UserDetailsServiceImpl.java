package com.project.stilgalleriet.security.services;

import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService { // Interface med metod/metoder för att hämta användarinformation för autentiseringsprocessen.
    @Autowired
    UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email) //Hittar en user via userns username(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email)); //

        /*//Generera saltat lösenord med BCrypt
        String saltedPassword = user.getPassword(); //Hämta lösenord från databasen

        //Hasha lösenordet med saltet
        String hashedPassword = new BCryptPasswordEncoder().encode(saltedPassword);*/

        return UserDetailsImpl.build(user);

    }
}
