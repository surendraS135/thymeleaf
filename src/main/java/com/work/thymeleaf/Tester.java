package com.work.thymeleaf;
import java.util.*;
public class Tester {


		    public static void main(String[] args) {  
		    	Math.random();
		    	
		    	System.out.println((new Random()).nextInt(100));
		        String str1 = String.format("%d", 101);          // Integer value  
		        String str2 = String.format("%s", "Amar Singh"); // String value  
		        String str3 = String.format("%f", 101.00);       // Float value  
		        String str4 = String.format("%02x", 101);          // Hexadecimal value  
		        String str5 = String.format("%c", 'c');          // Char value  
		        System.out.println(str1);  
		        System.out.println(str2);  
		        System.out.println(str3);  
		        System.out.println(Integer.parseInt(str5,16));  
		        System.out.println(str5);  
		    }  
		  
		

	

}
