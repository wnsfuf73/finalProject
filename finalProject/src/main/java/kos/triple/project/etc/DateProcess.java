package kos.triple.project.etc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateProcess{
    
	//System.out.println(diffOfDate("20031028", "20031102"));

  public long diffOfDate(String begin, String end) {
	  
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

    long diffDays;
    
    Date beginDate = null;
    Date endDate = null;
    
	try {
		beginDate = formatter.parse(begin);
		endDate = formatter.parse(end);
	} catch (ParseException e) {
		diffDays=0;
		e.printStackTrace();
	}

    long diff = endDate.getTime() - beginDate.getTime();
    diffDays = diff / (24 * 60 * 60 * 1000);

    return diffDays+1;
  }

  
  public String stringDate(String today , int add) {
	  
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  Date date = null;
	  try {
		  date = dateFormat.parse(today);
	  }
	  catch (ParseException e) {
		  e.printStackTrace();
	  }
	  
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(date);
	  cal.add(Calendar.DATE,add);
	  
	  String strDate = dateFormat.format(cal.getTime());
	  
	  return strDate;
  }



}