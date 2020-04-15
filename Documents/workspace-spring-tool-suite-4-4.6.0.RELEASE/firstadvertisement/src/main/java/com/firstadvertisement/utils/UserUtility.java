package com.firstadvertisement.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.firstadvertisement.entity.User;

public class UserUtility {
	
	public static List<User> convertUserEntityListToUserList(List<User> userEntityList) {
		List<User> userlist = new ArrayList<User>();
		Consumer<User> consumer = ((User user)->userlist.add(convertUserEntityToUser(user)));
		userEntityList.stream().forEach(consumer);
		return userlist;
	}
	
	public static User convertUserEntityToUser(User user) {
		return new User(user.getUsername(), user.getUserpassword(),user.getId());
	}

	public static User convertUserToUserEntity(User user) {
		return new User(user.getUsername(), user.getUserpassword(),user.getId());
	}
}
