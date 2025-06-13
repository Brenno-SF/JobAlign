package dev.bsf.JobAlign.services;

import dev.bsf.JobAlign.entity.User;
import dev.bsf.JobAlign.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public Optional<User> listById(UUID id){
        return userRepository.findById((id));
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public void deleteById(UUID id){
        userRepository.deleteById(id);
    }
}
