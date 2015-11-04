package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.jar.Attributes.Name;

public class test1 {
	public static void main(String[] args){

		Random randomGenerator = new Random();
		
		int C_Basic =300 ;
		float C_extra_per_diem=(float) 1.5;
		int C_rest_hotel=30;
		float C_rest_per_diem=(float) 0.1;
		float C_under_utility=(float) 0.2;
		
		int T_min_paid_fly = 5*30;
		int T_basic_duty_work = 8*30;
		int T_max = 13*30;
		int T_min_rest= 8*30;
		int T_max_duty=14*30;
		int T_max_duty_fly=11*30;
		int T_min_sit=30;
		int T_min_fly = 5*30;

		String[] airports = {"delhi","kolkata","patna","ranchi"};
		FlightClass[] flights ;


		FlightClass dop = new FlightClass("0","1","01/14/2012 08:00:00","01/14/2012 09:00:00","F0");
		FlightClass dok = new FlightClass("0", "3", "01/14/2012 09:30:00","01/14/2012 10:10:00", "F1");
		FlightClass dok1 = new FlightClass("3", "1", "01/14/2012 10:35:00","01/14/2012 11:35:00", "F2");
		FlightClass dok2 = new FlightClass("1", "2", "01/14/2012 09:20:00","01/14/2012 10:20:00", "F3");
		FlightClass dok3 = new FlightClass("2", "1", "01/14/2012 10:40:00","01/14/2012 11:40:00", "F4");
		FlightClass dok4 = new FlightClass("1", "0", "01/14/2012 12:30:00","01/14/2012 13:20:00", "F5");
		FlightClass dok5 = new FlightClass("0", "1", "01/14/2012 13:40:00","01/14/2012 15:10:00", "F6");
		FlightClass dok6 = new FlightClass("1", "0", "01/14/2012 15:20:00","01/14/2012 15:50:00", "F7");
		FlightClass dok7 = new FlightClass("1", "0", "01/14/2012 15:30:00","01/14/2012 16:30:00", "F8");

		FlightClass[] nop={dop,dok,dok1,dok2,dok3,dok4,dok5,dok6,dok7};

		//		for (FlightClass x : nop){
		//			System.out.println(x.name +" "+ x.origin +" " +x.destination+" "+x.d1+" "+x.d2);
		//		}

		String[] all_stations = {"0","1","2","3"};

		HashMap <String,ArrayList<FlightClass>> mapper = new HashMap();

		for (String x:all_stations){
			mapper.put(x, new ArrayList<FlightClass>());
		}

		for (String x: all_stations){
			for(FlightClass y : nop ){
				if (x.equals(y.origin)){
					System.out.println(y.name+" "+x +" to "+y.destination);
					mapper.get(x).add(y);
				}
			}
		}

		HashMap<FlightClass,FlightClass[] > mapper2 = new HashMap();
		FlightClass[] flightClass = {dok2,dok4,dok6,dok7 }; 
		Collections.shuffle(Arrays.asList(flightClass));
		mapper2.put(dop, flightClass);
		FlightClass[] flightClass1 = {dok1}; 
		Collections.shuffle(Arrays.asList(flightClass1));
		mapper2.put(dok, flightClass1);
		FlightClass[] flightClass2 = {dok4,dok6,dok7 }; 
		mapper2.put(dok1, flightClass2);
		FlightClass[] flightClass3 = {dok3}; 
		mapper2.put(dok2, flightClass3);
		FlightClass[] flightClass4 = {dok4,dok6,dok7 }; 
		mapper2.put(dok3, flightClass4);
		FlightClass[] flightClass5 = {dok5 }; 
		mapper2.put(dok4, flightClass5);
		FlightClass[] flightClass6 = {dok6,dok7 }; 
		mapper2.put(dok5, flightClass6);
		FlightClass[] flightClass7 = {}; 
		mapper2.put(dok6, flightClass7);
		FlightClass[] flightClass8 = {}; 
		mapper2.put(dok7, flightClass8);

		ArrayList<FlightClass> not_visited = new ArrayList();
		for (FlightClass x : nop){
			not_visited.add(x);
		}

		System.out.println();
		System.out.println();




		System.out.println();
		System.out.println();
		HashSet<String> Solutions= new HashSet();
		ArrayList Visited = new ArrayList<>();

		int index = randomGenerator.nextInt(mapper.get("0").size());

		String sol=null;

		ArrayList book =  new ArrayList<>();

		ArrayList<FlightClass> keeper = new ArrayList<>();

		ArrayList finalsol =  new ArrayList();

		while(!not_visited.isEmpty()){

			for(FlightClass class1 : nop){
				sol= class1.name;

				ArrayList top = new ArrayList();
				top.add(class1);


				while(!Visited.contains(class1)){
					Visited.add(class1);



					not_visited.remove(class1);
					keeper.add(class1);
					//			        		System.out.println(sol);
					FlightClass[] array  = mapper2.get(class1);
					if(array.length >0 ){
						for(FlightClass x:  array){
							if(!Visited.contains(x)){
								//			        				Visited.add(x);
								not_visited.remove(x);
								sol = sol+x.name;
								top.add(x);

								//			        				keeper.add(x);
								class1=x;
								//			        				System.out.println(sol);
								break;

							}
						}
					}else{
						//							System.out.println(sol);
						//							for(FlightClass k : keeper){
						//								System.out.println();
						//
						//								System.out.print(k.name);
						//							}
						keeper.clear();
					}



				}
				if(sol.length()  > 2){
					System.out.println(sol);
					finalsol.add(top);
				}


				//			        	keeper.clear();
				//			        	 if(sol.length()>2){
				//					        	System.out.println(sol);
				//					        	}
			}


		}





		System.out.println();
		System.out.println();



		ArrayList one = new ArrayList();
		ArrayList two = new ArrayList();
		one=(ArrayList) finalsol.get(0);
		two=(ArrayList) finalsol.get(1);

		FlightClass first =null;
		FlightClass first1 =null;
		FlightClass second =null;


		for(Object i : one)
		{
			FlightClass ko=(FlightClass) i;

			if(ko.origin=="0"){
				System.out.println(ko.name);
				first1=ko;

				if(one.indexOf(i)+1 != one.size()){

					FlightClass hop = ((FlightClass) one.get(one.indexOf(i)+1));
					System.out.println(hop.name);
					first=hop;

					for(FlightClass k:mapper2.get(ko)){
						System.out.print(k.name);
					}
					System.out.println();	
				}
			}
		}

		for(Object i : two)
		{
			FlightClass ko=(FlightClass) i;
			if(ko.origin=="0"){


				if(Arrays.asList(mapper2.get(ko)).contains(first)){
					System.out.println(ko.name);

					if(two.indexOf(i)+1 != two.size()){
						FlightClass hop = ((FlightClass) two.get(two.indexOf(i)+1));
						System.out.println(hop.name);
						second=hop;
						for(FlightClass k:mapper2.get(ko)){
							System.out.print(k.name);
						}
						if(Arrays.asList(mapper2.get(first1)).contains(second)){
							one.set( one.indexOf(first),second);
							two.set(two.indexOf(second), first);
						}

						System.out.println();

					}
				}
			}
		}



		System.out.println();
		System.out.println();

		for(Object x : finalsol){
			ArrayList k = (ArrayList) x;
			for (Object y : k){
				FlightClass s = (FlightClass) y;
				System.out.print(s.name);
			}
			System.out.println();
		}
		
		float total_cost=0 ;
		float extra_cost =0;
		float hotel_cost = 0 ;
		float rest_cost = 0;
		float under_cost  = 0 ; 
		
		for(Object x : finalsol){
			total_cost =total_cost+ C_Basic;
			float fly_time = 0;
			ArrayList k = (ArrayList) x;
			int size =  k.size();
			FlightClass z = (FlightClass) k.get(0);
			FlightClass z1= (FlightClass) k.get(size-1);
//			System.out.print(z.d1+" "+z1.d2);
			long[] tp = (timediff(z.d1,z1.d2));
			System.out.print(tp[1]*60+tp[2]);
			long ss = 0 ;
			for (Object y : k){
//				System.out.print(" "+fly_time+" ");
				FlightClass s = (FlightClass) y;
				System.out.print(s.name);
				long[] ko= timediff(s.d1,s.d2);
				fly_time=fly_time+ko[1]*60+ko[2];
				ss =(int) (+ ko[1]*60+ko[2]);
				if(ko[1]*60+ko[2] >80){
					fly_time=0;
					hotel_cost = hotel_cost + C_rest_hotel;
					rest_cost = (ko[1]*60+ko[2]* C_rest_per_diem);
					under_cost = (T_min_rest-ko[1]*60+ko[2])*C_under_utility;
					System.out.print(hotel_cost +" "+ rest_cost + " " + under_cost);
					total_cost = total_cost + hotel_cost+rest_cost+under_cost;
					System.out.println();
				}
				
//				System.out.print(ko[1]*60+ko[2]+" " );
//				System.out.print(fly_time);
			}
//			System.out.print(fly_time);
			
			if(fly_time >100){
				extra_cost =  (fly_time -100)*C_extra_per_diem;
				total_cost = total_cost +  extra_cost;
			}
			
			System.out.println();
			
		}


		System.out.println(total_cost);




		ArrayList<String> sols2= new ArrayList<>();

		//		for(String t : Solutions){
		//			for(String r:Solutions){
		//				
		//			}
		//		}
		//		
		//            for (String x:Solutions){
		//            	System.out.println(x);
		//            }

		//		 for(Map.Entry m:mapper.entrySet()){  
		//			   System.out.println(m.getKey()+" "+m.getValue());  
		//			  }  

	}

	public static void timediff(FlightClass flightClass,FlightClass flightClass2){

		timediff(flightClass.d1,flightClass2.d1);

	}
	
	public static void timediff1(FlightClass flightClass,FlightClass flightClass2){

		timediff(flightClass.d2,flightClass2.d1);

	}

	public static long[] timediff(Date d1,Date d2){
		long diff = d2.getTime() - d1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		/*System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");*/

		long[] result = {diffDays,diffHours,diffMinutes,diffSeconds};

		return result;

	}

}
