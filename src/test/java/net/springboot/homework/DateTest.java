package net.springboot.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		//LocalDate.now();
		//System.out.println(LocalDate.now());
		
//		Date d = new Date();
//		  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//			   try {
//				 d=  formatter.parse(formatter.format(new Date()));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			   System.out.println(d);   
			
		Date date = java.sql.Date.valueOf(LocalDate.now());
	//	Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		 System.out.println(date);   
	}

}
