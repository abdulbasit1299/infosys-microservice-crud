package com.infosys.springboot.restful.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserAPI {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAllUsers());
    }
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping
    public ResponseEntity create(@Valid @RequestBody User user) {
		
		System.out.println(user);
		System.out.println(user.getAccounts());
		//user.getAccounts().forEach(x -> x.setUserId(user.getId()));
		
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> stock = userService.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
        if (!userService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        user.setId(id);
        return ResponseEntity.ok(userService.save(user));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<User> patch(@PathVariable Long id, @Valid @RequestBody User user) {
        if (!userService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        user.setId(id);
        return ResponseEntity.ok(userService.save(user));
    }

    @SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!userService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        userService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
