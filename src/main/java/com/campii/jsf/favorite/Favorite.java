package com.campii.jsf.favorite;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.campii.jsf.camp.Camp;
import com.campii.jsf.dao.LoginDAO;
import com.campii.jsf.util.DataConnect;
import com.campii.jsf.util.SessionUtils;

@ManagedBean(name="favorite")
@SessionScoped
public class Favorite implements Serializable   {

	
	private static final long serialVersionUID = 1L;
	public String id;
	

	
	
	// to show favorite camps
	public List<Camp> getFavoriteCamps() throws ClassNotFoundException, SQLException {
	Connection con = null;
	
	String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection(
				"jdbc:mysql://cs.neiu.edu:3306/db_Spr19_nshasano", "db_Spr19_nshasano", "nshasano");
		
	} catch (Exception ex) {
		System.out.println("Database.getConnection() Error -->"
				+ ex.getMessage());
		
	}

	
	List<Camp> favoriteCamps = new ArrayList<Camp>();
				
	String s =	"SELECT c.campID, orgName, campName, genderType, activity, startDate, endDate, price, regStartDate , food, transportation, beforeCare, afterCare FROM P_Favorite f, P_Camp c,  P_Type t, P_Address a, P_Organization o, P_Gender g, P_User u  where f.campID = c.campID and f.userID = u.userID and u.userName ='" + username +"' and  g.genderID = c.genderID and o.campOrgID = c.campOrgID and t.typeID = c.typeID and c.addressID = a.addressID";
	
	
	
	
	PreparedStatement pstmt = con.prepareStatement(s);
	ResultSet rs = pstmt.executeQuery();

	while (rs.next()) {

		Camp camp = new Camp();
		camp.setOrgName(rs.getString("orgName"));
		camp.setCampName(rs.getString("campName"));
		camp.setGender(rs.getString("genderType"));
		camp.setActivity(rs.getString("activity"));
		camp.setPrice(rs.getInt("price"));
		camp.setRegistrationDay(rs.getString("regStartDate"));
		camp.setFood(rs.getBoolean("food"));
		camp.setTransportation(rs.getBoolean("transportation"));
		camp.setBeforeCare(rs.getBoolean("beforeCare"));
		camp.setAfterCare(rs.getBoolean("afterCare"));
		camp.setStartDate(rs.getString("startDate"));
		camp.setEndDate(rs.getString("endDate"));
		camp.setCampID(rs.getString("campID"));
		favoriteCamps.add(camp);

	}

	// close resources
	rs.close();
	pstmt.close();
	con.close();
	return favoriteCamps;
	
	}
	
	// Remove from favorite
	
public String remOutcome(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		this.id = getIDParam3(fc);
		
		String userID = "";
		
		String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
	
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select userID from P_User where userName = ?");
			ps.setString(1, username);
			

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
			
				userID = rs.getString("userID");
				
			}
				
				
			ps = con.prepareStatement("delete from P_Favorite  where userID = ? and campID= ?");
			ps.setString(1, userID);
			ps.setString(2, id);
			
		
			 ps.executeUpdate();
			 
			
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			
		} finally {
			DataConnect.close(con);
		}
		
		
		
	
		return "admin";
	}

	public String getIDParam3(FacesContext fc){
		
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("id3");
		
	}
	
	
	
	// Add to favorite
	public String favOutcome(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		this.id = getIDParam2(fc);
		String userID = "";
		System.out.println("FAvorite:" + id);
		String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
		if(username == null)
			{
				return "loginpage";
			
			}
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select userID from P_User where userName = ?");
			ps.setString(1, username);
			

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
			
				userID = rs.getString("userID");
			
			}
				
				
			ps = con.prepareStatement("INSERT INTO P_Favorite (userID, campID) VALUES (?, ?)");
			ps.setString(1, userID);
			ps.setString(2, id);
			

			 ps.executeUpdate();
			 
			
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			
		} finally {
			DataConnect.close(con);
		}
		
		
		
	
		return "searchweb";
	}

	public String getIDParam2(FacesContext fc){
		
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("id2");
		
	}
	
}