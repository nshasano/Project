package com.campii.jsf.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import com.campii.jsf.util.DataConnect;

@ManagedBean(name="user")
@SessionScoped
public class User {
	
	private String userID;
	private String userName;
	private String userPassword;
	private String firstName;
	private String middleName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	private String email;

    public User() {
    }

    public User(String userID, String userName, String userPassword, String firstName, String middleName, String lastName, String street, String city, String state, String zipCode, String phone, String email) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    
    
    
    public boolean validateUserName(String tempName)
    {
    	Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select userName from P_User where userName = ?" );
			ps.setString(1, tempName);
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return false;
				
			}
			
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		
    	
    	
    	return true;
    }
    
    public boolean validateUserEmail(String tempEmail)
    {
    	Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select email from P_User where email = ?" );
			ps.setString(1, tempEmail);
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
	
				return false;
				
			}
			
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		
    	
    	
    	return true;
    }
    public String register() throws ClassNotFoundException, SQLException {
    	
    	if(userPassword.length() <8)
    	{
    		FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Please enter longer Password. Password has to be at least 8 characters long.",""));
							
    	return null;	
    	}
    	
    	boolean checkUserName = validateUserName(userName);
    	
    	if(checkUserName == false)
    	{
    		FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Username is aleady used. Plese use another one.",""));
    	return null;	
    	}
    	
    	boolean checkUserEmail = validateUserEmail(email);
    	
    	if(checkUserEmail == false)
    	{
    		FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Email is aleady used. Plese use another one.",""));
    	return null;	
    	}
    		
    	Connection con = null;
    	PreparedStatement ps = null;
    	
    	String sha256hex = DigestUtils.sha256Hex("sfs#fdsf@151@fasfaFFAci123" +userPassword +"fa@das15%#$%$#fdsvE");
    		try {
    			con = DataConnect.getConnection();
    			ps = con.prepareStatement("INSERT into P_User(userName, userPassword, firstName, middleName, lastName, street, city, state, zipCode, phone, email) values (?, ? ,?,?, ? ,?,?, ? ,?,?, ?)");
    			ps.setString(1, userName);
    			ps.setString(2, sha256hex);
    			ps.setString(3, firstName);
    			ps.setString(4, middleName);
    			ps.setString(5, lastName);
    			ps.setString(6, street);
    			ps.setString(7, city);
    			ps.setString(8, state);
    			ps.setString(9, zipCode);
    			ps.setString(10, phone);
    			ps.setString(11, email);
    			
    			
    			System.out.println(ps);

    			
    			 ps.executeUpdate();
    		
    	
    			 
    			
    		} catch (SQLException ex) {
    			System.out.println("Login error -->" + ex.getMessage());
    		}
    		
    		return "loginpage";
    		
    }
}