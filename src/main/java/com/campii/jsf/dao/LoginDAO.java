package com.campii.jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import com.campii.jsf.util.DataConnect;

public class LoginDAO {

	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		
		String sha256hex = DigestUtils.sha256Hex("sfs#fdsf@151@fasfaFFAci123" +password + "fa@das15%#$%$#fdsvE");
	
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select userName, userPassword from P_User where userName = ? and userPassword = ?");
			ps.setString(1, user);
			ps.setString(2, sha256hex);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				return true;
				
			}
			
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
}