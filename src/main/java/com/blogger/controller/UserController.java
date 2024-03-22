package com.blogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogger.payloads.Apiresponse;
import com.blogger.payloads.UserDTO;
import com.blogger.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createuser")
	public ResponseEntity<UserDTO> createuser(@Valid @RequestBody UserDTO userDTO) {

		UserDTO createuser = this.userService.createuser(userDTO);
		return new ResponseEntity<>(createuser, HttpStatus.CREATED);
	}

	// Update User
	@PatchMapping("/updateuser/{userId}")
	public ResponseEntity<UserDTO> updateuser(@Valid @RequestBody UserDTO userDTO, @PathVariable("userId") Integer uid) {

		UserDTO updateuser = this.userService.updateuser(userDTO, uid);

		return ResponseEntity.ok(updateuser);
	}

	// Get All User
	@GetMapping(value = "/getalluser", produces = "application/json")
	public ResponseEntity<java.util.List<UserDTO>> getalluser() {

		return ResponseEntity.ok(this.userService.getalluser());

	}

	// Get user by ID
	@GetMapping("/getuserbyid/{userId}")
	public ResponseEntity<UserDTO> getuserbyid(@PathVariable("userId") Integer uid) {

		return ResponseEntity.ok(this.userService.getuserbyid(uid));
	}

	// Delete User
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<Apiresponse> deleteuser(@PathVariable("userId") Integer uid) {

		this.userService.deleteuser(uid);
		return new ResponseEntity<Apiresponse>(new Apiresponse("User deleted successfully", true), HttpStatus.OK);

	}

}
