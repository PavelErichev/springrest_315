package ru.Kata.Erichev.springrest_315.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.Kata.Erichev.springrest_315.entity.User;
import ru.Kata.Erichev.springrest_315.repository.UserRepository;

@Service
public class EmailBasedUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public EmailBasedUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}