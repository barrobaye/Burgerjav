package com.gestion.commande.demo.services;

import com.gestion.commande.demo.models.Users;
import com.gestion.commande.demo.repositories.UserRepository;
import lombok.extern.java.Log;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepo;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Users user = userRepo.findByEmail(username);
         System.out.println(username);
             if(user != null) {
             List<GrantedAuthority> roles = new ArrayList<>();
              roles.add(new SimpleGrantedAuthority(user.getRole().getLibelle()));
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, roles);
           }
        return null;
    }
}
