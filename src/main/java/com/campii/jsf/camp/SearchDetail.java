package com.campii.jsf.camp;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.PrimeFaces;

import com.campii.jsf.util.DataConnect;
import com.campii.jsf.review.Review;

@ManagedBean(name = "searchDetail")
@SessionScoped
public class SearchDetail implements Serializable {
	private String peopleRating = getRating();

	public List<String> compareList = new ArrayList<>();
	private boolean checkCompare;
	private static final long serialVersionUID = 1L;
	private Camp campDetail;
	public String id;
	private String campID;
	private String campName;
	private String orgName;
	private String activity;
	private String gender;
	private String minGrade;
	private String maxGrade;
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
	private List<Review> reviews;

	public static String campIDD;

	public String getText() {

		return text;
	}

	public void setText(String text) {

		this.text = text;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getPeopleRating() {
		return getRating();
	}

	public void setPeopleRating(String peopleRating) {
		this.peopleRating = peopleRating;
	}

	public List<String> getActivities() {
		return activities;
	}

	public void setActivities(List<String> activities) {
		this.activities = activities;
	}

	public void setCampDetail(Camp campDetail) {
		this.campDetail = campDetail;
	}

	public Camp getCampDetail() {
		return campDetail;
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public String getId() {
		return id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public boolean getCheckCompare() {
		return checkCompare;
	}

	public void setCheckCompare(boolean checkCompare) {
		this.checkCompare = checkCompare;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public boolean isFood() {

		return food;
	}

	public String getFood() {
		if (food == true)
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
		if (transportation == true)
			return "Transportation option available";
		else
			return "No transportation option available";

	}

	public String getBeforeCare() {
		if (beforeCare == true)
			return "Before care option available";
		else
			return "No before care option available";

	}

	public String getAfterCare() {
		if (afterCare == true)
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

	public String getStartDate() {
		String temp = "";
		String[] ans = startDate.split("-");
		temp = ans[1] + "/" + ans[2] + "/" + ans[0];

		return temp;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		String temp = "";
		String[] ans = endDate.split("-");
		temp = ans[1] + "/" + ans[2] + "/" + ans[0];

		return temp;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartHour() {
		String temp = "";
		String part = "";
		String[] ans = startHour.split(":");
		if (Integer.parseInt(ans[0]) > 12) {
			part = "pm";
		} else {
			part = "am";
		}
		temp = ans[0] + ":" + ans[2] + " " + part;
		String test = temp.charAt(0) + "";
		if (test.equals("0")) {
			return temp.substring(1);
		} else {
			return temp;
		}
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getEndHour() {
		String temp = "";
		String part = "";
		String[] ans = endHour.split(":");
		if (Integer.parseInt(ans[0]) > 12) {
			part = "pm";
		} else {
			part = "am";
		}
		temp = ans[0] + ":" + ans[2] + " " + part;
		String test = temp.charAt(0) + "";
		if (test.equals("0")) {
			return temp.substring(1);
		} else {
			return temp;
		}

	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
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

	// get reviews

	public List<Review> getReviewsTest() throws ClassNotFoundException, SQLException {
		FacesContext fc = FacesContext.getCurrentInstance();
		String id = getIDParam(fc);

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"Select userName, text from P_Camp c, P_User u, P_Feedback f where u.userID = f.userID and c.campID = f.campID and c.campID = "
							+ id);

			System.out.println(ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Review review = new Review();
				review.setText(rs.getString("text"));
				review.setUsername(rs.getString("userName"));

				reviews.add(review);

			}

		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());

		} finally {
			DataConnect.close(con);
		}

		return reviews;

	}

	// Expand to details
	public String outcome() {

		FacesContext fc = FacesContext.getCurrentInstance();
		this.id = getIDParam(fc);
		System.out.println("detail:" + id);

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_nshasano", "db_Spr19_nshasano",
					"nshasano");

			String s = "SELECT campID, orgName, campName, genderType,  startDate, endDate, price, regStartDate , food, startHour, endHour,transportation, beforeCare, afterCare, latitude , longitude   FROM P_Camp c,  P_Type t, P_Address a, P_Organization o, P_Gender g  where g.genderID = c.genderID and o.campOrgID = c.campOrgID and t.typeID = c.typeID and c.addressID = a.addressID and c.campID = "
					+ id;
			PreparedStatement pstmt = con.prepareStatement(s);
			System.out.println(s);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				setCampName(rs.getString("campName"));
				setOrgName(rs.getString("orgName"));
				setGender(rs.getString("genderType"));
				setPrice(rs.getInt("price"));
				setRegistrationDay(rs.getString("regStartDate"));
				setFood(rs.getBoolean("food"));
				setTransportation(rs.getBoolean("transportation"));
				setBeforeCare(rs.getBoolean("beforeCare"));
				setAfterCare(rs.getBoolean("afterCare"));
				setStartDate(rs.getString("startDate"));
				setEndDate(rs.getString("endDate"));
				setStartHour(rs.getString("startHour"));
				setEndHour(rs.getString("endHour"));
				setCampID(rs.getString("campID"));
				setLatitude(rs.getString("latitude"));
				setLongitude(rs.getString("longitude"));

				setActivities(getActivitiesTest(rs.getString("campID")));
			}
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());

		}

		reviews = new ArrayList<Review>();
		try {
			reviews = getReviewsTest();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		campIDD = getIDParam(fc);
		System.out.println("globalni id " + campIDD);
		return "detail";
	}

	public String getIDParam(FacesContext fc) {

		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("id");

	}

	public String getRating() {
		FacesContext fc = FacesContext.getCurrentInstance();
		id = getIDParam(fc);
		String ans = "";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("SELECT avg(rating) from P_Review where campID = ?");
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ans = rs.getString("avg(rating)");
			}

		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
		}

		if (ans != null) {
			String[] arr = ans.split("\\.");

			return arr[0];
		}
		return null;
	}

	public String sendRating() {

		String userID = "";

		String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("username");
		if (username == null) {
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

			ps = con.prepareStatement("INSERT INTO P_Review (userID, campID, rating) VALUES (?, ?, ?)");
			ps.setString(1, userID);
			ps.setString(2, id);
			ps.setInt(3, getValue());

			ps.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());

		} finally {
			DataConnect.close(con);
		}

		return null;
	}

	public String insertReview() {
		System.out.println("test zacatek feedback");
		String userID = "";

		System.out.println("globalni id " + campIDD);

		String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("username");
		if (username == null) {
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

			ps = con.prepareStatement("INSERT INTO P_Feedback (userID, campID, text) VALUES (?, ?, ?)");
			ps.setString(1, userID);
			ps.setString(2, campIDD);
			ps.setString(3, getText());
			System.out.println("test feedback");
			System.out.println(ps);
			ps.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());

		} finally {
			DataConnect.close(con);
		}

		return null;
	}

	public String getIDParam2(FacesContext fc) {

		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("id2");

	}

	public List<String> getActivitiesTest(String idCamp) throws ClassNotFoundException, SQLException {
		List<String> activ = new ArrayList<String>();
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_nshasano", "db_Spr19_nshasano",
					"nshasano");

		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());

		}

		String s = "select activity from P_CampType ct, P_Type t where t.typeID = ct.typeID and ct.campID = " + idCamp;

		System.out.println(s);
		PreparedStatement pstmt = con.prepareStatement(s);
		ResultSet rs = pstmt.executeQuery();
		String temp = "";
		while (rs.next()) {

			temp = rs.getString("activity");
			activ.add(temp);

		}
		return activ;

	}

	public String pricePerDay() {
		double xx = getNumberOfDays();

		double ans = this.price / xx;
		ans = Math.round(ans * 100);
		ans = ans / 100.0;

		return ans + "";
	}

	public int getNumberOfDays() {

		String beginning = getDateMonday(this.startDate);
		String end = getDateMonday(this.endDate);

		String[] array1 = beginning.split("-");
		String[] array2 = end.split("-");

		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int ans = 0;
		int monthStart = Integer.parseInt(array1[1]);
		int monthEnd = Integer.parseInt(array2[1]);

		if (monthStart == monthEnd) {
			return Integer.parseInt(array2[2]) - Integer.parseInt(array1[2]);
		}
		if (monthStart + 1 == monthEnd) {
			ans = Integer.parseInt(array2[2]);
			ans = ans + months[Integer.parseInt(array1[1]) - 1] - Integer.parseInt(array1[1]);
			return ans;
		}

		ans = Integer.parseInt(array2[2]);

		ans = ans + months[Integer.parseInt(array1[1]) - 1] - Integer.parseInt(array1[2]);

		monthEnd--;
		while (monthStart != monthEnd) {
			ans = ans + months[monthEnd - 1];

			monthEnd--;
		}

		if (ans == 0)
			return 5;
		ans = ans / 7;
		ans++;
		ans = ans * 5;
		return ans;
	}

	public static boolean isLeapYear(int year) {
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

	public String getDateMonday(String checkDate) {
		String ans = "";
		String temp = checkDate + "";
		String[] arr = temp.split("-");
		String month = "";
		String day = arr[2];
		int dayGood = 0;
		String year = arr[0];
		int calc = 0;
		boolean checkLeap = isLeapYear(Integer.parseInt(year));
		// Check leap year

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.ENGLISH);
		Date myDate = null;
		try {
			myDate = (Date) sdf.parse(checkDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sdf.applyPattern("EEE");
		String sMyDate = sdf.format(myDate);

		// Months
		if (arr[1].equals("01")) {
			if (sMyDate.equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "12";
					day = dayGood + "";
				} else {
					month = "01";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "12";
					day = dayGood + "";
				} else {
					month = "01";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "12";
					day = dayGood + "";
				} else {
					month = "01";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "12";
					day = dayGood + "";
				} else {
					month = "01";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "12";
					day = dayGood + "";
				} else {
					month = "01";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "12";
					day = dayGood + "";
				} else {
					month = "01";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "12";
					day = dayGood + "";
				} else {
					month = "01";
					day = calc + "";
				}
			}
		}
		if (arr[1].equals("02")) {
			if (sMyDate.equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "01";
					day = dayGood + "";
				} else {
					month = "02";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "01";
					day = dayGood + "";
				} else {
					month = "02";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "01";
					day = dayGood + "";
				} else {
					month = "02";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "01";
					day = dayGood + "";
				} else {
					month = "02";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "01";
					day = dayGood + "";
				} else {
					month = "02";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "01";
					day = dayGood + "";
				} else {
					month = "02";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "01";
					day = dayGood + "";
				} else {
					month = "02";
					day = calc + "";
				}
			}
		}
		if (arr[1].equals("03")) {
			if (checkLeap == false) {
				if (sMyDate.equals("Mon")) {
					calc = Integer.parseInt(day) - 0;
					if (calc < 1) {
						dayGood = 28 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Tue")) {
					calc = Integer.parseInt(day) - 1;
					if (calc < 1) {
						dayGood = 28 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Wed")) {
					calc = Integer.parseInt(day) - 2;
					if (calc < 1) {
						dayGood = 28 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Thu")) {
					calc = Integer.parseInt(day) - 3;
					if (calc < 1) {
						dayGood = 28 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Fri")) {
					calc = Integer.parseInt(day) - 4;
					if (calc < 1) {
						dayGood = 28 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Sat")) {
					calc = Integer.parseInt(day) - 5;
					if (calc < 1) {
						dayGood = 28 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Sun")) {
					calc = Integer.parseInt(day) - 6;
					if (calc < 1) {
						dayGood = 28 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}

			} else {
				if (sMyDate.equals("Mon")) {
					calc = Integer.parseInt(day) - 0;
					if (calc < 1) {
						dayGood = 29 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Tue")) {
					calc = Integer.parseInt(day) - 1;
					if (calc < 1) {
						dayGood = 29 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Wed")) {
					calc = Integer.parseInt(day) - 2;
					if (calc < 1) {
						dayGood = 29 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Thu")) {
					calc = Integer.parseInt(day) - 3;
					if (calc < 1) {
						dayGood = 29 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Fri")) {
					calc = Integer.parseInt(day) - 4;
					if (calc < 1) {
						dayGood = 29 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Sat")) {
					calc = Integer.parseInt(day) - 5;
					if (calc < 1) {
						dayGood = 29 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}
				if (sMyDate.equals("Sun")) {
					calc = Integer.parseInt(day) - 6;
					if (calc < 1) {
						dayGood = 29 + calc;
						month = "02";
						day = dayGood + "";
					} else {
						month = "03";
						day = calc + "";
					}
				}

			}
		}

		if (arr[1].equals("04")) {
			if (sMyDate.equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "03";
					day = dayGood + "";
				} else {
					month = "04";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "03";
					day = dayGood + "";
				} else {
					month = "04";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "03";
					day = dayGood + "";
				} else {
					month = "04";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "03";
					day = dayGood + "";
				} else {
					month = "04";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "03";
					day = dayGood + "";
				} else {
					month = "04";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "03";
					day = dayGood + "";
				} else {
					month = "04";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "03";
					day = dayGood + "";
				} else {
					month = "04";
					day = calc + "";
				}
			}
		}
		if (arr[1].equals("05")) {
			if (sMyDate.equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "04";
					day = dayGood + "";
				} else {
					month = "05";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "04";
					day = dayGood + "";
				} else {
					month = "05";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "04";
					day = dayGood + "";
				} else {
					month = "05";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "04";
					day = dayGood + "";
				} else {
					month = "05";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "04";
					day = dayGood + "";
				} else {
					month = "05";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "04";
					day = dayGood + "";
				} else {
					month = "05";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "04";
					day = dayGood + "";
				} else {
					month = "05";
					day = calc + "";
				}
			}
		}
		if (arr[1].equals("06")) {
			if (sMyDate.equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "05";
					day = dayGood + "";
				} else {
					month = "06";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "05";
					day = dayGood + "";
				} else {
					month = "06";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "05";
					day = dayGood + "";
				} else {
					month = "06";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "05";
					day = dayGood + "";
				} else {
					month = "06";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "05";
					day = dayGood + "";
				} else {
					month = "06";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "05";
					day = dayGood + "";
				} else {
					month = "06";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "05";
					day = dayGood + "";
				} else {
					month = "06";
					day = calc + "";
				}
			}
		}
		if (arr[1].equals("07")) {
			if (sMyDate.equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "06";
					day = dayGood + "";
				} else {
					month = "07";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "06";
					day = dayGood + "";
				} else {
					month = "07";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "06";
					day = dayGood + "";
				} else {
					month = "07";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "06";
					day = dayGood + "";
				} else {
					month = "07";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "06";
					day = dayGood + "";
				} else {
					month = "07";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "06";
					day = dayGood + "";
				} else {
					month = "07";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "06";
					day = dayGood + "";
				} else {
					month = "07";
					day = calc + "";
				}
			}
		}
		if (arr[1].equals("08")) {
			if (sMyDate.equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "07";
					day = dayGood + "";
				} else {
					month = "08";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "07";
					day = dayGood + "";
				} else {
					month = "08";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "07";
					day = dayGood + "";
				} else {
					month = "08";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "07";
					day = dayGood + "";
				} else {
					month = "08";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "07";
					day = dayGood + "";
				} else {
					month = "08";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "07";
					day = dayGood + "";
				} else {
					month = "08";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "07";
					day = dayGood + "";
				} else {
					month = "08";
					day = calc + "";
				}
			}
		}
		if (arr[1].equals("09")) {
			if (sMyDate.equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "08";
					day = dayGood + "";
				} else {
					month = "09";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "08";
					day = dayGood + "";
				} else {
					month = "09";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "08";
					day = dayGood + "";
				} else {
					month = "09";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "08";
					day = dayGood + "";
				} else {
					month = "09";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "08";
					day = dayGood + "";
				} else {
					month = "09";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "08";
					day = dayGood + "";
				} else {
					month = "09";
					day = calc + "";
				}
			}
			if (sMyDate.equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "08";
					day = dayGood + "";
				} else {
					month = "09";
					day = calc + "";
				}
			}
		}
		if (arr[1].equals("10")) {
			if (arr[0].equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "09";
					day = dayGood + "";
				} else {
					month = "10";
					day = calc + "";
				}
			}
			if (arr[0].equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "09";
					day = dayGood + "";
				} else {
					month = "10";
					day = calc + "";
				}
			}
			if (arr[0].equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "09";
					day = dayGood + "";
				} else {
					month = "10";
					day = calc + "";
				}
			}
			if (arr[0].equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "09";
					day = dayGood + "";
				} else {
					month = "10";
					day = calc + "";
				}
			}
			if (arr[0].equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "09";
					day = dayGood + "";
				} else {
					month = "10";
					day = calc + "";
				}
			}
			if (arr[0].equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "09";
					day = dayGood + "";
				} else {
					month = "10";
					day = calc + "";
				}
			}
			if (arr[0].equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "09";
					day = dayGood + "";
				} else {
					month = "10";
					day = calc + "";
				}
			}
		}
		if (arr[1].equals("11")) {
			if (arr[0].equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "10";
					day = dayGood + "";
				} else {
					month = "11";
					day = calc + "";
				}
			}
			if (arr[0].equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "10";
					day = dayGood + "";
				} else {
					month = "11";
					day = calc + "";
				}
			}
			if (arr[0].equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "10";
					day = dayGood + "";
				} else {
					month = "11";
					day = calc + "";
				}
			}
			if (arr[0].equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "10";
					day = dayGood + "";
				} else {
					month = "11";
					day = calc + "";
				}
			}
			if (arr[0].equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "10";
					day = dayGood + "";
				} else {
					month = "11";
					day = calc + "";
				}
			}
			if (arr[0].equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "10";
					day = dayGood + "";
				} else {
					month = "11";
					day = calc + "";
				}
			}
			if (arr[0].equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 31 + calc;
					month = "10";
					day = dayGood + "";
				} else {
					month = "11";
					day = calc + "";
				}
			}

		}
		if (arr[1].equals("12")) {
			if (arr[0].equals("Mon")) {
				calc = Integer.parseInt(day) - 0;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "11";
					day = dayGood + "";
				} else {
					month = "12";
					day = calc + "";
				}
			}
			if (arr[0].equals("Tue")) {
				calc = Integer.parseInt(day) - 1;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "11";
					day = dayGood + "";
				} else {
					month = "12";
					day = calc + "";
				}
			}
			if (arr[0].equals("Wed")) {
				calc = Integer.parseInt(day) - 2;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "11";
					day = dayGood + "";
				} else {
					month = "12";
					day = calc + "";
				}
			}
			if (arr[0].equals("Thu")) {
				calc = Integer.parseInt(day) - 3;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "11";
					day = dayGood + "";
				} else {
					month = "12";
					day = calc + "";
				}
			}
			if (arr[0].equals("Fri")) {
				calc = Integer.parseInt(day) - 4;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "11";
					day = dayGood + "";
				} else {
					month = "12";
					day = calc + "";
				}
			}
			if (arr[0].equals("Sat")) {
				calc = Integer.parseInt(day) - 5;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "11";
					day = dayGood + "";
				} else {
					month = "12";
					day = calc + "";
				}
			}
			if (arr[0].equals("Sun")) {
				calc = Integer.parseInt(day) - 6;
				if (calc < 1) {
					dayGood = 30 + calc;
					month = "11";
					day = dayGood + "";
				} else {
					month = "12";
					day = calc + "";
				}
			}

		}

		ans = year + "-" + month + "-" + day;

		return ans;

	}

}