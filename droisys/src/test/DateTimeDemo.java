package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		
		/*long s=System.currentTimeMillis();
		System.out.println(s);*/
		
		DateFormat dateFormat = new SimpleDateFormat("MM-yyyy-dd HH.mm.ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		

	}

}
