package com.firstadvertisement.services;
import java.util.List;

import com.firstadvertisement.entity.User;

public interface UserService {
	
public List<User> getAllUsers();
	
	public String login(User user);
	
	public User getCurrentUserDetails(String id);
	
	public User save(User user);
	
	public User logout(String key); 
	
	public boolean delete(String id);
	
	public User update(User user);
	
	public List<User> getUsersByOrderByUserNameAsc();
	
	public List<User> getUsersByOrderByUserNameDesc();
	
}



