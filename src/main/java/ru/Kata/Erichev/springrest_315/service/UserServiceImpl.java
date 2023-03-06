package ru.Kata.Erichev.springrest_315.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Kata.Erichev.springrest_315.entity.Role;
import ru.Kata.Erichev.springrest_315.entity.User;
import ru.Kata.Erichev.springrest_315.repository.RoleRepository;
import ru.Kata.Erichev.springrest_315.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void saveUser(User user, String[] role) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Set<Role> rolesSet = new HashSet<>();
        for (String roles : role) {
            rolesSet.add(roleRepository.getByName(roles));
        }
        user.setRoles(rolesSet);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean deleteUser(long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}