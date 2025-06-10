package dev.bsf.JobAlign.controllers;

import dev.bsf.JobAlign.entity.User;
import dev.bsf.JobAlign.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.random.RandomGenerator;

@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping("/Register")
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userServices.create(user));
    }
    @GetMapping()
    public ResponseEntity<List<User>> listAll(){
        return ResponseEntity.ok(userServices.listAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> listById(@PathVariable String id){
        return ResponseEntity.ok(userServices.listById(id).orElseThrow(() -> new RuntimeException("User Not Found")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user){

        return userServices.listById(id)
                .map(userExists -> {
                    user.setUserId(userExists.getUserId());
                    User userUpdated = userServices.update(user);
                    return ResponseEntity.ok(userUpdated);
                    })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        userServices.deleteById(id);
        return ResponseEntity.ok("User has deleted");
    }
}
