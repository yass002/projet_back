package tn.cni.annuaire.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cni.annuaire.dto.User;
import tn.cni.annuaire.services.UserService;


 
@RestController
@RequestMapping("/user")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @PostMapping("/add-user")
    public ResponseEntity<String> bindLdapPerson(@RequestBody User user) {
    	userService.save(user);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
 
//    @PutMapping("/update-user")
//    public ResponseEntity<String> rebindLdapPerson(@RequestBody Person person) {
//        String result = personRepo.update(person);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
// 
    @GetMapping("/retrieve-users")
    public ResponseEntity<List<User>> retrieve() {
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }
// 
//    @GetMapping("/remove-user")
//    public ResponseEntity<String> unbindLdapPerson(@RequestParam(name = "userId") String userId) {
//        String result = personRepo.remove(userId);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
}