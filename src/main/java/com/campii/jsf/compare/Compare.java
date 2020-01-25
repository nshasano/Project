package com.campii.jsf.compare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;

import com.campii.jsf.camp.Camp;
import com.campii.jsf.util.DataConnect;

@ManagedBean(name="compare")
@SessionScoped

public class Compare{
	public List<String> getActivities() {
        return activities;
	}
 
	public void setActivities( List<String> activities) {
        this.activities = activities;
	}
	
	public List<Camp> getCompareCamps(  ) {
        return this.compareCamps;
    }
	
	public void setCompareCamps(List<Camp> compareCamps ) {
        this.compareCamps  = compareCamps ;
    }
	  public String submit2() {
	    	
		  System.out.println("Submit FUNGUJE");
		  init();
	        return "compare";
	    }
	  
	  
	  List<Camp> compareCamps;
	private List<String> activities;
	public List<String> compareList = new ArrayList<>();
	private boolean checkCompare;
	
	
	@PostConstruct
    public void init() {
		compareCamps = new ArrayList<Camp>();
		try {
			compareCamps = getCompareCampsTest();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("POST FUNGUJE");
	}
	
	
	
	public String test = "";

	public void  attrListener(ActionEvent event){
		 
		test =  (String)event.getComponent().getAttributes().get("id44");
	 
	  }

	public boolean getCheckCompare() {
		
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		String test = params.get("id2");
		System.out.println("TY VOLEEEE" + test);
		
		
		if(compareList.contains(getIDParam2(fc)))
		{
			
			return true;
			
		}
		else
		{
			
			return false;
		
		}

        
	}

	public void setCheckCompare(boolean checkCompare) {
        this.checkCompare = checkCompare;
	}
	
	
public String getIDParam2(FacesContext fc){
		
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("id2");
		
	}
	

	
	

	
	public boolean checkCompareSelection()
	{
		
		return true;
	}
	
	// remove form compare list
	
	public String removeCompare() {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		String campID = getIDParam2(fc);
		
		System.out.println(campID);
		compareList.remove(getIDParam2(fc));
		
		compareCamps = new ArrayList<Camp>();
		try {
			compareCamps = getCompareCampsTest();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "compare";
	}
	// ADD TO Compare list
	public String compare() {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		
		
		 
		
		if(getCheckCompare() == false)
		{
		
			if(compareList.size() > 3)
			{
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Maximum exceded", "You cannot pick more than 4");
		         
		        PrimeFaces.current().dialog().showMessageDynamic(message);
		     
		        System.out.println("test");
		        return null;

			}
			
		
			if(!(compareList.contains(getIDParam2(fc))))
			{
				compareList.add(getIDParam2(fc));

			}
		}
		else
		{
			
			compareList.remove(getIDParam2(fc));
		}
		System.out.println(compareList);
		return null;
	}
	
	public List<Camp> getCompareCampsTest() throws ClassNotFoundException, SQLException {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataConnect.getConnection();
	   		String s = "SELECT DISTINCT c.campID, orgName, campName, genderType, startDate, startHour, endHour, endDate, price, regStartDate , food, transportation, beforeCare, afterCare, latitude , longitude   FROM P_Camp c,  P_Type t, P_Address a, P_Organization o, P_Gender g , P_CampType ct  where g.genderID = c.genderID and o.campOrgID = c.campOrgID and t.typeID = ct.typeID and ct.campID = c.campID and c.addressID = a.addressID";
	   		if(compareList.size() > 0)
	   		{
	   		 s+= " and ( ";
	   		}
	   		for (int i = 0; i < compareList.size() - 1; i++) 
	   		{
	           s+= "  c.campID = " + compareList.get(i) + " or " ; 
	   		}
	   		s+= "  c.campID = " +compareList.get(compareList.size() -1 ) + " )";
	           
	           System.out.println(s);
	           ps = con.prepareStatement(s);
		
			

			ResultSet rs = ps.executeQuery();
			
			
		

	

		while (rs.next()) {

			Camp camp = new Camp();
			camp.setOrgName(rs.getString("orgName"));
			camp.setCampName(rs.getString("campName"));
			camp.setGender(rs.getString("genderType"));
			camp.setPrice(rs.getInt("price"));
			camp.setRegistrationDay(rs.getString("regStartDate"));
			camp.setFood(rs.getBoolean("food"));
			camp.setTransportation(rs.getBoolean("transportation"));
			camp.setBeforeCare(rs.getBoolean("beforeCare"));
			camp.setAfterCare(rs.getBoolean("afterCare"));
			camp.setStartDate(rs.getString("startDate"));
			camp.setEndDate(rs.getString("endDate"));
   			camp.setStartHour(rs.getString("startHour"));
   			camp.setEndHour(rs.getString("endHour"));
			camp.setCampID(rs.getString("campID"));
			
			
			 try {
		   			camp.setActivities( getActivitiesTest (rs.getString("campID")));
		  		} catch (ClassNotFoundException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		} catch (SQLException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}
			 
			 
			compareCamps.add(camp);

		}
		
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			
		}
		
		
		
		con.close();
		return compareCamps;
		
		}
	
	public List<String> getActivitiesTest (String idCamp) throws ClassNotFoundException, SQLException {
		 List<String> activ =new ArrayList<String>();
		Connection con = null;
  		try {
  			Class.forName("com.mysql.jdbc.Driver");
  			 con = DriverManager.getConnection(
  					"jdbc:mysql://cs.neiu.edu:3306/db_Spr19_nshasano", "db_Spr19_nshasano", "nshasano");
  			
  		} catch (Exception ex) {
  			System.out.println("Database.getConnection() Error -->"
  					+ ex.getMessage());
  			
  		}
  		
		
		String s = "select activity from P_CampType ct, P_Type t where t.typeID = ct.typeID and ct.campID = " + idCamp;
		
		System.out.println(s);
		PreparedStatement pstmt = con.prepareStatement(s);
  		ResultSet rs = pstmt.executeQuery();
  		String temp ="";
  		while (rs.next()) {

  			
  			temp = rs.getString("activity");
  			activ.add(temp);
  		
  		}
		return activ;
   
	}
	
	
}