package com.zee.zee5app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.InvalidNameException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.MovieServiceImpl;
import com.zee.zee5app.service.UserService;
//import com.zee.zee5app.repo.UserRepo;
import com.zee.zee5app.service.UserServiceImpl;
import com.zee.zee5app.utils.IdComparator;

public class Main {
	public static void main(String[] args) {
//		User user = new User(); 
	/*		User : ClassName
			user : reference(local reference)
			new : to create object in the heap
			User : Constructor(IDC)
			 */
		
	UserService userService = UserServiceImpl.getInstance();
	MovieService movieService = MovieServiceImpl.getInstance();
	
	//inserting user
	try {
		userService.insertUser(new User("John", "Wick", "ss@gmail.com", LocalDate.now(), LocalDate.of(1980, 7, 15), true));
	} catch (UnableToGenerateIdException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//inserting movie
	String[] actors = { "Dq Salman", "Tagore" };
    String[] languages = { "Telugu", "Malayalam", "Tamil" };
	try {
		movieService.insertMovie(new Movie(actors, "Sita Rama", "eshwar Amagi", "Romantic", "MB", languages, (float) 2.30, "D:\\Zee5App\\Trailer\\videoplayback.mp4"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidIdException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidNameException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//	//getting user by id
//	Optional<User>result = userService.getUserById("ab002");
//	if(!result.isPresent()) 
//		System.out.println("No Record Found");
//	else {
//		User user = result.get();
//		//.get() will convert Optional to User,User[] 
//		System.out.println(user);
//	}
//	System.out.println();
//	
//	//update user by id
//		try {
//			Optional<User> result4 = userService.updateUserById("ab002",new User("John", "Wick", "jw@gmail.com", LocalDate.now(), LocalDate.of(1980, 7, 15), true));
//			System.out.println(result4);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////			System.out.println("UserId is not Valid");
//		}
//		System.out.println();
//	
//	//delete user by id
//	try {
//		String result3 = userService.deleteUserById("ab004");
//		System.out.println(result3);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		System.out.println("UserId not found");
//	}
//	System.out.println();
//	
//	//getting all users
//		Optional<List<User>>result2 = userService.getAllUsers();
//		if(!result2.isPresent())
//			System.out.println("No Users");
//		else {
//			for(User user : result2) {
//				System.out.println(user);
//			}
//		}
//		UserRepo userRepo = new UserRepo(); 
		
//		UserRepo userRepo = UserRepo.getInstance();
//		UserRepo userRepo2 = UserRepo.getInstance();
//		System.out.println(userRepo == userRepo2);
//		for(User tempUser : userRepo.publicUsers) {
//			System.out.println(tempUser);
//		}
		// System : class
		// out : static reference
		// println : Method from PrintStream Class
		
//		User user1 = new User("1","abc","def","ad@gmail.com",LocalDate.of(1998, 10, 11),LocalDate.of(1998, 10, 11),true);
//		User user2 = new User("2","ghi","jkl","gj@gmail.com",LocalDate.of(1998, 10, 11),LocalDate.of(1998, 10, 11),true);
////		int output = 1;
//		
//		
//		String[] actors = {"a","b","c"};
//        String[] languages ={Languages.KANNADA.name(),
//                Languages.TAMIL.name(),Languages.TELUGU.name(),
//                Languages.HINDI.name()
//                ,"c"};
//        Movie newMovie = new Movie(null, actors, null, null, null, null, languages, 0);
//		
////		Movie newMovie = null;
////		try {
////			newMovie.setActors(actors);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////			newMovie = new Movie();
////		}
//		
//		for(int i=1;i<=5;i++) {
//			switch(i){
//			case 1:
//				//insert user
//				User result1 = userService.insertUser(user1);
//				User result5 = userService.insertUser(user2);
//				System.out.println(result1);
//				break;
//			case 2:
//				//getting user by ID
//				User specific = userService.getUserById("1");
//				System.out.println(specific);
//				break;
//			case 3:
//				//getting all users
//				User[] everyOne = userService.getAllUsers();
//				if(everyOne == null) {
//					System.out.println("no record found");
//				}
//				else {
//					for(User tempUser : everyOne) {
//						if(tempUser != null) System.out.println(tempUser);
//					}
//				}
//				break;
//			case 4:
//				//delete user
//				String result2 = userService.deleteUserById("1");
//				System.out.println(result2);
//				break;
//			case 5:
//				//update user
//				User user3 = new User("3","mno","pqr","gj@gmail.com",LocalDate.of(1998, 10, 11),LocalDate.of(1998, 10, 11),true);
//				User result3 = userService.updateUserById("2",user3);
//				System.out.println(result3);
//				break;
//			default:
//				System.out.println("Enter a Valid input");
//		}
//		}
//		
//		System.out.println(user);
//		System.out.println(user.toString());
//		System.out.println(user.getClass().getName());
//		System.out.println(user.hashCode());
//		System.out.println(Integer.toHexString(user.hashCode()));
	}
}
