package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import io.opentelemetry.sdk.metrics.data.Data;

public class JavaUtility {

	
	public  int  getRandomNumber()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		
		return randomNumber;
	}
	public String getSystemDataYYYYDDMM()
	{
		Date dateobj = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		String data = sdf.format(dateobj);
		
		return data;
	}
	
	public String getRequiedDataYYYYDDMM(int days)
	{
		Date dateobj = new Date();
		
		System.out.println(dateobj);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String data = sdf.format(dateobj);
		
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate=  sdf.format(cal.getTime());
		return reqdate;
		
		
	}
	
	public static void main(String[] args) {
		JavaUtility j = new JavaUtility();
		j.getSystemDataYYYYDDMM();
		 System.out.println(j.getRequiedDataYYYYDDMM(12));
	}
}
