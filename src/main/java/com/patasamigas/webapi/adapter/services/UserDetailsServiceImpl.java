package com.patasamigas.webapi.adapter.services;

import com.patasamigas.webapi.adapter.persistance.UserRepository;
import com.patasamigas.webapi.adapter.persistance.entities.UserDetailsEntity;
import com.patasamigas.webapi.adapter.persistance.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDetailsEntity(user);
    }

}
