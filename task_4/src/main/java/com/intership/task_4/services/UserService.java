package com.intership.task_4.services;

import java.util.List;
import java.util.ArrayList;

import com.intership.task_4.model.UserModel;
import com.intership.task_4.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveMyUser(UserModel user) {userRepository.save(user);}

    public List<UserModel> showAllUsers(){
        List<UserModel> userModels = new ArrayList<>();
        for (UserModel user : userRepository.findAll()) {
            userModels.add(user);
        }
        return userModels;
    }
    public void deleteUser(Long id) { userRepository.deleteById(id);}
    public UserModel editUser(Long id) {return userRepository.findById(id).get();  }
}
