package com.jjdev.JJE_commerce.services;

import com.jjdev.JJE_commerce.entities.User;
import com.jjdev.JJE_commerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User insert(User user){
       return userRepository.save(user);
    }

    public void deleteUser (Long id){
        userRepository.deleteById(id);
    }
}
