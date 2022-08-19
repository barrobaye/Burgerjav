package com.gestion.commande.demo.services;

import com.gestion.commande.demo.repositories.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepo;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // User user = userRepo.findByEmail(username);
        //     System.out.println(username);
        //     if(user != null) {
        //      List<GrantedAuthority> roles = new ArrayList<>();
        //      roles.add(new SimpleGrantedAuthority(user.getRole().getLibelle()));
        //      return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, roles);
        //     }
        return null;
    }
}
