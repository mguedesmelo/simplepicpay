package com.simplepicpay.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplepicpay.dto.UserRequestDto;
import com.simplepicpay.exception.BusinessException;
import com.simplepicpay.model.User;
import com.simplepicpay.service.UserService;
import com.simplepicpay.shared.StringUtil;

@RestController
@RequestMapping("/api")
public class UserRestController {
	@Autowired
	private UserService userService;

	@GetMapping("/me")
	public ResponseEntity<User> me() throws BusinessException {
		// TODO Should return a DTO??
		User toReturn = null;
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!StringUtil.isNullOrEmpty(email)) {
            toReturn = this.userService.findByEmail(email);
        }
		return new ResponseEntity<User>(toReturn, HttpStatus.OK);
	}

	@PostMapping("/open/user")
	public ResponseEntity<User> save(@RequestBody UserRequestDto userDto) throws BusinessException {
		User user = this.userService.save(userDto);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<List<User>> findAll() {
		List<User> toReturn = this.userService.findAll();
		return new ResponseEntity<List<User>>(toReturn, HttpStatus.OK);
	}
}
