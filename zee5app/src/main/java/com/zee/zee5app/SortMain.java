package com.zee.zee5app;

import java.util.Arrays;
import java.util.List;

public class SortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		:: -> method reference -> used to call for static reference
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		list.forEach(e->System.out.println(e)); //recommended for now
		list.forEach(System.out::println); //recommended in the future
	}

}
