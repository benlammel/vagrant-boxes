package ch.lammel.photobooth.webservice.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testMain {

	public static void main(String[] args) {
		

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss_SSS");
		Date date = new Date();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss_SSS").format(new Date())); //2016/11/16 12:08:43

	}

}
