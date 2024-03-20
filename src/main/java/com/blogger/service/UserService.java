package com.blogger.service;

import java.util.List;

import com.blogger.payloads.UserDTO;

public interface UserService {

	UserDTO createuser(UserDTO userDTO);
	
	UserDTO updateuser(UserDTO user, Integer userid);

	UserDTO getuserbyid(Integer userid);

	List<UserDTO> getalluser();

	void deleteuser(Integer userid);
}
