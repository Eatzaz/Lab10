package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void addAllUsers(User user){
        userRepository.save(user);
    }
    public boolean updateUser(Integer id,User user){
        User user1=userRepository.getById(id);
        if(user1==null){
            return false;
        }
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setAge(user.getAge());
        user1.setRole(user.getRole());
        userRepository.save(user);
        return true;
    }
    public boolean deleteuser(Integer id){
        User user=userRepository.getById(id);
        if(user==null){
            return false;
        }
        userRepository.delete(user);
        return true;
    }
}
