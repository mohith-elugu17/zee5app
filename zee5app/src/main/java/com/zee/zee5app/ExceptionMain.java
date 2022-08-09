package com.zee.zee5app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.InvalidIdException;

public class ExceptionMain {
    
    public static int methodA() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
    
    public static void methodB() throws FileNotFoundException {
        methodA();
        
    }
    public static void methodC() throws FileNotFoundException {
        methodB();
    }
    
public static void main(String[] args) {
        
        try {
            methodC();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
    




//package com.zee.zee5app;
//
//import java.util.Scanner;
//
//public class ExceptionMain {
//
//	public static void main(String[] args) {
//		int a = 0, b = 0, c = 0;
//		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		try {
//			System.out.println("Enter the number");
//			a = scanner.nextInt();
//			System.out.println("Enter the number");
//			b = scanner.nextInt();
//			c = a/b;
//		} catch (ArithmeticException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			int count = 0;
//			while(true)
//			{
//				++count;
//				if(b == 0) {
//					if(count == 4) break;
//					System.out.println("Enter the value again");
//					b = scanner.nextInt();
//				}
//				else
//				{
//					c = a/b;
//					break;
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//		finally {
//			System.out.println("some closure work");
//		}
//	}
//
//}
