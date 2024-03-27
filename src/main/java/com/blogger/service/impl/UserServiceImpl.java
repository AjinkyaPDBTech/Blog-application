package com.blogger.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogger.Repo.UserRepo;
import com.blogger.entity.User;
import com.blogger.exception.ResourceNotFoundException;
import com.blogger.payloads.UserDTO;
import com.blogger.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createuser(UserDTO userDTO) {

		User dtotouser = this.dtotouser(userDTO);

		User user = this.userRepo.save(dtotouser);

		return this.usertodto(user);
	}

	@Override
	public UserDTO updateuser(UserDTO userDto, Integer userid) {
		User user = this.userRepo.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userid));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		User updateduser = this.userRepo.save(user);

		UserDTO userDTO1 = this.usertodto(updateduser);

		return userDTO1;
	}

	@Override
	public UserDTO getuserbyid(Integer userid) {
		User user = this.userRepo.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userid));

		return this.usertodto(user);
	}

	@Override
	public List<UserDTO> getalluser() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> userdtos = users.stream().map(user -> this.usertodto(user)).collect(Collectors.toList());
		return userdtos;
	}

	@Override
	public void deleteuser(Integer userid) {
		User user = this.userRepo.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userid));
		this.userRepo.delete(user);

	}

	public User dtotouser(UserDTO userDTO) {

		User user = this.modelMapper.map(userDTO, User.class);
//		user.setId(userDTO.getId());
//		user.setName(userDTO.getName());
//		user.setEmail(userDTO.getEmail());
//		user.setPassword(userDTO.getPassword());
//		user.setAbout(userDTO.getAbout());
		return user;
	}

	public UserDTO usertodto(User user) {

		UserDTO userdto = this.modelMapper.map(user, UserDTO.class);
//		userdto.setId(user.getId());
//		userdto.setName(user.getName());
//		userdto.setEmail(user.getEmail());
//		userdto.setPassword(user.getPassword());
//		userdto.setAbout(user.getAbout());
		return userdto;

	}
}
