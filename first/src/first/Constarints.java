package first;

import java.util.Date;

public class Constarints {
	
	public void timediff(FlightClass flightClass,FlightClass flightClass2){
		
		timediff(flightClass.d1,flightClass2.d1);
		
	}
	
	 public static long[] timediff(Date d1,Date d2){
	    	long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
			
			long[] result = {diffDays,diffHours,diffMinutes,diffSeconds};
			
			return result;
			
		}

}
