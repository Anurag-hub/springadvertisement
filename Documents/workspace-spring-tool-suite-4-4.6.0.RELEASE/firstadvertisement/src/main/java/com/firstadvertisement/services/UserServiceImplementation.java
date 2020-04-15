package com.firstadvertisement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstadvertisement.entity.User;
import com.firstadvertisement.repository.UserRepository;
import com.firstadvertisement.utils.UserUtility;
 

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userrepository;

	public User update(User user) {
		User userEntity = userrepository.findById(user.getId()).get();
		if(userEntity != null) {
			userEntity.setUsername(user.getUsername());
			userEntity.setUserpassword(user.getUserpassword());
			userEntity = userrepository.save(userEntity);
			return UserUtility.convertUserEntityToUser(userEntity);
		}
		return null;
	}
	public boolean delete(String id) {
		if(userrepository.existsById(Long.valueOf(id))) {
			userrepository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}
	
	public List<User> getUsersByOrderByUserNameAsc() {
		List<User> userlist = userrepository.findByOrderByusernameAsc();
		return UserUtility.convertUserEntityListToUserList(userlist);
	}

	public List<User> getUsersByOrderByUserNameDesc() {
		List<User> userlist = userrepository.findByOrderByusernameDesc();
		return UserUtility.convertUserEntityListToUserList(userlist);
	}
	public List<User> getAllUsers() {
			List<User> userlist = userrepository.findAll();
			return UserUtility.convertUserEntityListToUserList(userlist);
		}
	
	public User getCurrentUserDetails(String id) {
	User currentuser = userrepository.findBySessionId(id).get(0);
		return UserUtility.convertUserEntityToUser(currentuser);	
		}
	
	public User save(User user) {
		User currentuser=userrepository.save(user);
		return userrepository.save(user);
	}

	
	public User logout(String key) {
		User currentuser=userrepository.findBySessionId(key).get(0);
		currentuser.setSessionId(null);
		User user=userrepository.save(currentuser);	
		return UserUtility.convertUserEntityToUser(user);
	}

	public String login(User user) {
		String username=user.getUsername();
		String userpassword=user.getUserpassword();
		List<User> userlist=userrepository.findByusername(username);
		if(userlist==null || userlist.size()==0) {
			return "{ \"result\": \"failed\", \"message\": \"Invalid User\"" +username+"}";
		}
		else {
			User currentuser=userlist.get(0);
			if(userpassword.equals(currentuser.getUserpassword())) {//login success
				String sessionId =new java.rmi.server.UID().toString().substring(0,10);
				currentuser.setSessionId(sessionId);
				userrepository.save(currentuser);
				return "{ \"result\": \"success\", \"message\": \"Login successful\",\"auth-token\":\"" + sessionId +"\"}";

			}
			else {//wrong password
				return "{ \"result\": \"failed\", \"message\": \"Invalid password\" }";

			}
		}
		
	}
}
	
