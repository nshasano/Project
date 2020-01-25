
package com.campii.jsf.camp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.primefaces.model.LazyDataModel;

public class Camp {

	private String campID;
	private String campName;
	private String orgName;
	private String activity;
	private String gender;
	private String minGrade;
	private String maxGrade;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;
	private String sunday;
	private String startDate;
	private String endDate;
	private String startHour;
	private String endHour;
	private String duration;
	private int price;
	private String registrationDay;
	private boolean food;
	private boolean transportation;
	private boolean beforeCare;
	private boolean afterCare;
	private boolean selected;
	private String phone;
	private String email;
	private String web;
	private String text;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String season;
	private String longitude;
	private String latitude;
	private List<String> activities;
	
	public Camp() {
	}

	public Camp(String campName, String orgName, String activity, String gender, String minGrade, String maxGrade,
			String monday, String tuesday, String wednesday, String thursday, String friday, String saturday,
			String sunday, String startDate, String endDate, String startHour, String endHour, String duration,
			int price, String registrationDay, boolean food, boolean transportation, boolean beforeCare,
			boolean afterCare, String phone, String email, String web, String text, String street, String city,
			String state, String zipcode, String season, String campID, String longitude, String  latitude, List<String> activities) {
        this.campName = campName;
        this.orgName = orgName;
        this.activity = activity;
        this.gender = gender;
        this.minGrade = minGrade;
        this.maxGrade = maxGrade;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startHour = startHour;
        this.endHour = endHour;
        this.duration = duration;
        this.price = price;
        this.registrationDay = registrationDay;
        this.food = food;
        this.transportation = transportation;
        this.beforeCare = beforeCare;
        this.afterCare = afterCare;
        this.phone = phone;
        this.email = email;
        this.web = web;
        this.text = text;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.season = season;
        this.campID = campID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.activities=activities;
    }
	public List<String> getActivities() {
	        return activities;
	}
	 
	public void setActivities( List<String> activities) {
	        this.activities = activities;
	}
	public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
	public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
	public String getCampID() {
        return campID;
    }

    public void setCampID(String campID) {
        this.campID = campID;
    }
    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(String minGrade) {
        this.minGrade = minGrade;
    }

    public String getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(String maxGrade) {
        this.maxGrade = maxGrade;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getStartDate() {
    	String temp = "";
        String [] ans = startDate.split("-");
    	temp = ans[1] +"/"+ans[2]+"/"+ans[0];
    	
    	return temp;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        String temp = "";
        String [] ans = endDate.split("-");
    	temp = ans[1] +"/"+ans[2]+"/"+ans[0];
    	
    	return temp;
    }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartHour() {
    	  String temp = "";
    	  String part ="";
          String [] ans = startHour.split(":");
          if(Integer.parseInt(ans[0]) > 12)
          {
        	  part = "pm";
          }
          else
          {
        	  part = "am";
          }
      	temp = ans[0] +":"+ans[2] + " " +part;
      	String test = temp.charAt(0)+"";
      	if(test.equals("0"))
      	{
      		return temp.substring(1);
      	}
      	else
      	{
      	return temp;  
      	}
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
  	  String temp = "";
	  String part ="";
      String [] ans = endHour.split(":");
      if(Integer.parseInt(ans[0]) > 12)
      {
    	  part = "pm";
      }
      else
      {
    	  part = "am";
      }
  	temp = ans[0] +":"+ans[2] + " " +part;
  	String test = temp.charAt(0)+"";
  	if(test.equals("0"))
  	{
  		return temp.substring(1);
  	}
  	else
  	{
  	return temp;  
  	}
  	
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegistrationDay() {
        return registrationDay;
    }

    public void setRegistrationDay(String registrationDay) {
        this.registrationDay = registrationDay;
    }

    
  public boolean isSelected() {
    	
        return selected;
    }

    public boolean getSelected() {
    	return selected;
    	
    }
    
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public boolean isFood() {
    	
        return food;
    }

    public String getFood() {
    	if (food== true)
    			return "Lunch provided";
    			else
    				return "No lunch provided";
    	
    }
    
    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isTransportation() {
        return transportation;
    }

    public void setTransportation(boolean transportation) {
        this.transportation = transportation;
    }
    
    public String getTransportation() {
        if(transportation == true)
    	  return "Transportation option available";
        else
          return "No transportation option available";
    	
    	
    }
    
    public String getBeforeCare() {
        if(beforeCare == true)
    	  return "Before care option available";
        else
          return "No before care option available";

    }
    public String getAfterCare() {
        if(afterCare == true)
    	  return "After care option available";
        else
          return "No after care option available";

    }
    public boolean isBeforeCare() {
        return beforeCare;
    }

    public void setBeforeCare(boolean beforeCare) {
        this.beforeCare = beforeCare;
    }

    public boolean isAfterCare() {
        return afterCare;
    }

    public void setAfterCare(boolean afterCare) {
        this.afterCare = afterCare;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    
    public  double pricePerDay()
    {
    	double xx = getNumberOfDays();
   
    	
    	
    	double ans =  this.price/xx;
    	ans = Math.round(ans * 100);
    	ans = ans/100.0;
    	
    	return ans;
    }
    
    public static boolean isLeapYear(int year)
    {
		  if (year % 4 != 0) {
		    return false;
		  } else if (year % 400 == 0) {
		    return true;
		  } else if (year % 100 == 0) {
		    return false;
		  } else {
		    return true;
		  }
	}
    
    public int getNumberOfDays()
    {
    	
    	
   
    	String beginning = getDateMonday(this.startDate);
    	String end = getDateMonday(this.endDate);
    	
    	String [] array1 = beginning.split("-");
    	String [] array2 = end.split("-");
    	
    	int [] months = {31,28,31,30,31,30,31,31,30,31,30,31};
    	int ans =0;
    	int monthStart = Integer.parseInt(array1[1]);
    	int monthEnd = Integer.parseInt(array2[1]);
    	
    	if(monthStart == monthEnd)
    	{
    		return Integer.parseInt(array2[2]) - Integer.parseInt(array1[2]);
    	}
    	if(monthStart+1 == monthEnd)
    	{
    		ans = Integer.parseInt(array2[2]);
    		ans = ans + months[Integer.parseInt(array1[1])-1] -   Integer.parseInt(array1[1]);
    		return ans;
    	}
    	
    	ans = Integer.parseInt(array2[2]);
    
    	ans =  ans + months[Integer.parseInt(array1[1])-1] -   Integer.parseInt(array1[2]);
    
    	monthEnd--;
    	while(monthStart != monthEnd)
    	{
    		ans = ans + months[monthEnd-1];
    		
    		monthEnd--;
    	}
    
    	
    	if(ans ==0)
    		return 5;
    	ans = ans /7;
    	ans++;
    	ans = ans *5;
    	return ans;		
    }
	public String getDateMonday(String checkDate) 
	{
		String ans ="";
		String temp = checkDate + "";
		String[] arr = temp.split("-");
		String month = "";
		String day = arr[2];
		int dayGood=0;
		String year = arr[0];
		int calc = 0;
		boolean checkLeap = isLeapYear(Integer.parseInt(year));
		// Check leap year
	
		 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.ENGLISH);
		Date myDate = null;
		try {
			myDate =  (Date) sdf.parse(checkDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sdf.applyPattern("EEE");
		String sMyDate = sdf.format(myDate);
		
		// Months
		if(arr[1].equals("01"))
		{
			if(sMyDate.equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "12";
					day = dayGood + "";
				}
				else
				{
					month = "01";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "12";
					day = dayGood + "";
				}
				else
				{
					month = "01";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "12";
					day = dayGood + "";
				}
				else
				{
					month = "01";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "12";
					day = dayGood + "";
				}
				else
				{
					month = "01";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "12";
					day = dayGood + "";
				}
				else
				{
					month = "01";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "12";
					day = dayGood + "";
				}
				else
				{
					month = "01";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "12";
					day = dayGood + "";
				}
				else
				{
					month = "01";
					day = calc+"";
				}
			}
		}
		if(arr[1].equals("02"))
		{
			if(sMyDate.equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "01";
					day = dayGood + "";
				}
				else
				{
					month = "02";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "01";
					day = dayGood + "";
				}
				else
				{
					month = "02";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "01";
					day = dayGood + "";
				}
				else
				{
					month = "02";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "01";
					day = dayGood + "";
				}
				else
				{
					month = "02";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "01";
					day = dayGood + "";
				}
				else
				{
					month = "02";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "01";
					day = dayGood + "";
				}
				else
				{
					month = "02";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "01";
					day = dayGood + "";
				}
				else
				{
					month = "02";
					day = calc+"";
				}
			}
		}
		if(arr[1].equals("03"))
		{
			if(checkLeap == false)
			{
			if(sMyDate.equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  28 + calc;
					month = "02";
					day = dayGood + "";
				}
				else
				{
					month = "03";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  28 + calc;
					month = "02";
					day = dayGood + "";
				}
				else
				{
					month = "03";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  28 + calc;
					month = "02";
					day = dayGood + "";
				}
				else
				{
					month = "03";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  28 + calc;
					month = "02";
					day = dayGood + "";
				}
				else
				{
					month = "03";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  28 + calc;
					month = "02";
					day = dayGood + "";
				}
				else
				{
					month = "03";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  28 + calc;
					month = "02";
					day = dayGood + "";
				}
				else
				{
					month = "03";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  28 + calc;
					month = "02";
					day = dayGood + "";
				}
				else
				{
					month = "03";
					day = calc+"";
				}
			}
		
			}
			else
			{
				if(sMyDate.equals("Mon"))
				{
					calc = Integer.parseInt(day) - 0;
					if(calc <1)
					{
						dayGood =  29 + calc;
						month = "02";
						day = dayGood + "";
					}
					else
					{
						month = "03";
						day = calc+"";
					}
				}
				if(sMyDate.equals("Tue"))
				{
					calc = Integer.parseInt(day) - 1;
					if(calc <1)
					{
						dayGood =  29 + calc;
						month = "02";
						day = dayGood + "";
					}
					else
					{
						month = "03";
						day = calc+"";
					}
				}
				if(sMyDate.equals("Wed"))
				{
					calc = Integer.parseInt(day) - 2;
					if(calc <1)
					{
						dayGood =  29 + calc;
						month = "02";
						day = dayGood + "";
					}
					else
					{
						month = "03";
						day = calc+"";
					}
				}
				if(sMyDate.equals("Thu"))
				{
					calc = Integer.parseInt(day) - 3;
					if(calc <1)
					{
						dayGood =  29 + calc;
						month = "02";
						day = dayGood + "";
					}
					else
					{
						month = "03";
						day = calc+"";
					}
				}
				if(sMyDate.equals("Fri"))
				{
					calc = Integer.parseInt(day) - 4;
					if(calc <1)
					{
						dayGood =  29 + calc;
						month = "02";
						day = dayGood + "";
					}
					else
					{
						month = "03";
						day = calc+"";
					}
				}
				if(sMyDate.equals("Sat"))
				{
					calc = Integer.parseInt(day) - 5;
					if(calc <1)
					{
						dayGood =  29 + calc;
						month = "02";
						day = dayGood + "";
					}
					else
					{
						month = "03";
						day = calc+"";
					}
				}
				if(sMyDate.equals("Sun"))
				{
					calc = Integer.parseInt(day) - 6;
					if(calc <1)
					{
						dayGood =  29 + calc;
						month = "02";
						day = dayGood + "";
					}
					else
					{
						month = "03";
						day = calc+"";
					}
				}
				
				
				
				
				
				
			}
	}
			
		if(arr[1].equals("04"))
		{
			if(sMyDate.equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "03";
					day = dayGood + "";
				}
				else
				{
					month = "04";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "03";
					day = dayGood + "";
				}
				else
				{
					month = "04";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "03";
					day = dayGood + "";
				}
				else
				{
					month = "04";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "03";
					day = dayGood + "";
				}
				else
				{
					month = "04";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "03";
					day = dayGood + "";
				}
				else
				{
					month = "04";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "03";
					day = dayGood + "";
				}
				else
				{
					month = "04";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "03";
					day = dayGood + "";
				}
				else
				{
					month = "04";
					day = calc+"";
				}
			}
		}
		if(arr[1].equals("05"))
		{
			if(sMyDate.equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "04";
					day = dayGood + "";
				}
				else
				{
					month = "05";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "04";
					day = dayGood + "";
				}
				else
				{
					month = "05";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "04";
					day = dayGood + "";
				}
				else
				{
					month = "05";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "04";
					day = dayGood + "";
				}
				else
				{
					month = "05";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "04";
					day = dayGood + "";
				}
				else
				{
					month = "05";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "04";
					day = dayGood + "";
				}
				else
				{
					month = "05";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "04";
					day = dayGood + "";
				}
				else
				{
					month = "05";
					day = calc+"";
				}
			}
		}
		if(arr[1].equals("06"))
		{
			if(sMyDate.equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "05";
					day = dayGood + "";
				}
				else
				{
					month = "06";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "05";
					day = dayGood + "";
				}
				else
				{
					month = "06";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "05";
					day = dayGood + "";
				}
				else
				{
					month = "06";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "05";
					day = dayGood + "";
				}
				else
				{
					month = "06";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "05";
					day = dayGood + "";
				}
				else
				{
					month = "06";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "05";
					day = dayGood + "";
				}
				else
				{
					month = "06";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "05";
					day = dayGood + "";
				}
				else
				{
					month = "06";
					day = calc+"";
				}
			}
		}
		if(arr[1].equals("07"))
		{
			if(sMyDate.equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "06";
					day = dayGood + "";
				}
				else
				{
					month = "07";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "06";
					day = dayGood + "";
				}
				else
				{
					month = "07";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "06";
					day = dayGood + "";
				}
				else
				{
					month = "07";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "06";
					day = dayGood + "";
				}
				else
				{
					month = "07";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "06";
					day = dayGood + "";
				}
				else
				{
					month = "07";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "06";
					day = dayGood + "";
				}
				else
				{
					month = "07";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "06";
					day = dayGood + "";
				}
				else
				{
					month = "07";
					day = calc+"";
				}
			}
		}
		if(arr[1].equals("08"))
		{
			if(sMyDate.equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "07";
					day = dayGood + "";
				}
				else
				{
					month = "08";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "07";
					day = dayGood + "";
				}
				else
				{
					month = "08";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "07";
					day = dayGood + "";
				}
				else
				{
					month = "08";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "07";
					day = dayGood + "";
				}
				else
				{
					month = "08";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "07";
					day = dayGood + "";
				}
				else
				{
					month = "08";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "07";
					day = dayGood + "";
				}
				else
				{
					month = "08";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "07";
					day = dayGood + "";
				}
				else
				{
					month = "08";
					day = calc+"";
				}
			}
		}
		if(arr[1].equals("09"))
		{
			if(sMyDate.equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "08";
					day = dayGood + "";
				}
				else
				{
					month = "09";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "08";
					day = dayGood + "";
				}
				else
				{
					month = "09";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "08";
					day = dayGood + "";
				}
				else
				{
					month = "09";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "08";
					day = dayGood + "";
				}
				else
				{
					month = "09";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "08";
					day = dayGood + "";
				}
				else
				{
					month = "09";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "08";
					day = dayGood + "";
				}
				else
				{
					month = "09";
					day = calc+"";
				}
			}
			if(sMyDate.equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "08";
					day = dayGood + "";
				}
				else
				{
					month = "09";
					day = calc+"";
				}
			}
		}
		if(arr[1].equals("10"))
		{
			if(arr[0].equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "09";
					day = dayGood + "";
				}
				else
				{
					month = "10";
					day = calc+"";
				}
			}
			if(arr[0].equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "09";
					day = dayGood + "";
				}
				else
				{
					month = "10";
					day = calc+"";
				}
			}
			if(arr[0].equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "09";
					day = dayGood + "";
				}
				else
				{
					month = "10";
					day = calc+"";
				}
			}
			if(arr[0].equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "09";
					day = dayGood + "";
				}
				else
				{
					month = "10";
					day = calc+"";
				}
			}
			if(arr[0].equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "09";
					day = dayGood + "";
				}
				else
				{
					month = "10";
					day = calc+"";
				}
			}
			if(arr[0].equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "09";
					day = dayGood + "";
				}
				else
				{
					month = "10";
					day = calc+"";
				}
			}
			if(arr[0].equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "09";
					day = dayGood + "";
				}
				else
				{
					month = "10";
					day = calc+"";
				}
			}
		}
		if(arr[1].equals("11"))
		{
			if(arr[0].equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "10";
					day = dayGood + "";
				}
				else
				{
					month = "11";
					day = calc+"";
				}
			}
			if(arr[0].equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "10";
					day = dayGood + "";
				}
				else
				{
					month = "11";
					day = calc+"";
				}
			}
			if(arr[0].equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "10";
					day = dayGood + "";
				}
				else
				{
					month = "11";
					day = calc+"";
				}
			}
			if(arr[0].equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "10";
					day = dayGood + "";
				}
				else
				{
					month = "11";
					day = calc+"";
				}
			}
			if(arr[0].equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "10";
					day = dayGood + "";
				}
				else
				{
					month = "11";
					day = calc+"";
				}
			}
			if(arr[0].equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "10";
					day = dayGood + "";
				}
				else
				{
					month = "11";
					day = calc+"";
				}
			}
			if(arr[0].equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  31 + calc;
					month = "10";
					day = dayGood + "";
				}
				else
				{
					month = "11";
					day = calc+"";
				}
			}
	
		}
		if(arr[1].equals("12"))
		{
			if(arr[0].equals("Mon"))
			{
				calc = Integer.parseInt(day) - 0;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "11";
					day = dayGood + "";
				}
				else
				{
					month = "12";
					day = calc+"";
				}
			}
			if(arr[0].equals("Tue"))
			{
				calc = Integer.parseInt(day) - 1;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "11";
					day = dayGood + "";
				}
				else
				{
					month = "12";
					day = calc+"";
				}
			}
			if(arr[0].equals("Wed"))
			{
				calc = Integer.parseInt(day) - 2;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "11";
					day = dayGood + "";
				}
				else
				{
					month = "12";
					day = calc+"";
				}
			}
			if(arr[0].equals("Thu"))
			{
				calc = Integer.parseInt(day) - 3;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "11";
					day = dayGood + "";
				}
				else
				{
					month = "12";
					day = calc+"";
				}
			}
			if(arr[0].equals("Fri"))
			{
				calc = Integer.parseInt(day) - 4;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "11";
					day = dayGood + "";
				}
				else
				{
					month = "12";
					day = calc+"";
				}
			}
			if(arr[0].equals("Sat"))
			{
				calc = Integer.parseInt(day) - 5;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "11";
					day = dayGood + "";
				}
				else
				{
					month = "12";
					day = calc+"";
				}
			}
			if(arr[0].equals("Sun"))
			{
				calc = Integer.parseInt(day) - 6;
				if(calc <1)
				{
					dayGood =  30 + calc;
					month = "11";
					day = dayGood + "";
				}
				else
				{
					month = "12";
					day = calc+"";
				}
			}
	
		}	
		
		

		ans = year +"-"+month+"-" + day;
		
		return ans;
		
	}

	


		
		
}


