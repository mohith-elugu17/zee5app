package com.zee.zee5app;

import java.util.HashSet;

import com.zee.zee5app.dto.User;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hashSet = new HashSet();
		User user = new User();
		User user2 = new User();
		User user3 = new User();
		hashSet.add(user);
		hashSet.add(user2);
		hashSet.add(user3);
		System.out.println(hashSet);
	}

}
