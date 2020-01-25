package com.campii.jsf.camp;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.event.data.PageEvent;
import org.primefaces.model.LazyDataModel;

// <p:graphicImage name="demo/images/car/#{car.brand}.gif"/> 

@ManagedBean(name = "search")
@SessionScoped
public class Search implements Serializable {

	public int radius;
	private static final long serialVersionUID = 1094801825228386364L;
	private LazyDataModel<Camp> lazyModel;
	private int first;
	// public boolean sFood;
	private boolean checkFood;
	private boolean checkTransportation;
	private boolean checkBeforeHours;
	private boolean checkAfterHours;
	private String checkType;
	private String checkGrade;
	private String checkPrice;
	private String zipCode;
	private Date checkDate;
	private String checkLat;
	private String checkLon;
	private String checkRadius = "2.4999";
	private List<SelectItem> campList;
	private String[] selectedCamps;
	private List<Camp> camps;
	private String[] typeList;

	public int getRadius() {
		return radius;
	}

	public void setkRadius(int radius) {
		this.radius = radius;
	}

	public String getCheckRadius() {
		return checkRadius;
	}

	public void setCheckRadius(String checkRadius) {
		this.checkRadius = checkRadius;
	}

	public String getCheckLon() {
		return checkLon;
	}

	public void setCheckLon(String checkLon) {
		this.checkLon = checkLon;
	}

	public String getCheckLat() {
		return checkLat;
	}

	public void setCheckLat(String checkLat) {
		this.checkLat = checkLat;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public String[] getTypeList() {
		return typeList;
	}

	public void setTypeList(String[] typeList) {
		this.typeList = typeList;
	}

	public Date getCheckDate() {

		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
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

	public String getDateMonday() {
		String ans = "";
		String temp = this.checkDate + "";
		String[] arr = temp.split(" ");
		String month = "";
		String day = arr[2];
		int dayGood = 0;
		String year = arr[5];
		int calc = 0;
		boolean checkLeap = isLeapYear(Integer.parseInt(year));
		// Check leap year

		// Months
		if (arr[1].equals("Jan")) {
			if (arr[0].equals("Mon")) {
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
			if (arr[0].equals("Tue")) {
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
			if (arr[0].equals("Wed")) {
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
			if (arr[0].equals("Thu")) {
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
			if (arr[0].equals("Fri")) {
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
			if (arr[0].equals("Sat")) {
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
			if (arr[0].equals("Sun")) {
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
		if (arr[1].equals("Feb")) {
			if (arr[0].equals("Mon")) {
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
			if (arr[0].equals("Tue")) {
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
			if (arr[0].equals("Wed")) {
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
			if (arr[0].equals("Thu")) {
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
			if (arr[0].equals("Fri")) {
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
			if (arr[0].equals("Sat")) {
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
			if (arr[0].equals("Sun")) {
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
		if (arr[1].equals("Mar")) {
			if (checkLeap == false) {
				if (arr[0].equals("Mon")) {
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
				if (arr[0].equals("Tue")) {
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
				if (arr[0].equals("Wed")) {
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
				if (arr[0].equals("Thu")) {
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
				if (arr[0].equals("Fri")) {
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
				if (arr[0].equals("Sat")) {
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
				if (arr[0].equals("Sun")) {
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
				if (arr[0].equals("Mon")) {
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
				if (arr[0].equals("Tue")) {
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
				if (arr[0].equals("Wed")) {
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
				if (arr[0].equals("Thu")) {
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
				if (arr[0].equals("Fri")) {
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
				if (arr[0].equals("Sat")) {
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
				if (arr[0].equals("Sun")) {
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

		if (arr[1].equals("Apr")) {
			if (arr[0].equals("Mon")) {
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
			if (arr[0].equals("Tue")) {
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
			if (arr[0].equals("Wed")) {
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
			if (arr[0].equals("Thu")) {
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
			if (arr[0].equals("Fri")) {
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
			if (arr[0].equals("Sat")) {
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
			if (arr[0].equals("Sun")) {
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
		if (arr[1].equals("May")) {
			if (arr[0].equals("Mon")) {
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
			if (arr[0].equals("Tue")) {
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
			if (arr[0].equals("Wed")) {
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
			if (arr[0].equals("Thu")) {
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
			if (arr[0].equals("Fri")) {
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
			if (arr[0].equals("Sat")) {
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
			if (arr[0].equals("Sun")) {
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
		if (arr[1].equals("Jun")) {
			if (arr[0].equals("Mon")) {
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
			if (arr[0].equals("Tue")) {
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
			if (arr[0].equals("Wed")) {
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
			if (arr[0].equals("Thu")) {
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
			if (arr[0].equals("Fri")) {
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
			if (arr[0].equals("Sat")) {
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
			if (arr[0].equals("Sun")) {
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
		if (arr[1].equals("Jul")) {
			if (arr[0].equals("Mon")) {
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
			if (arr[0].equals("Tue")) {
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
			if (arr[0].equals("Wed")) {
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
			if (arr[0].equals("Thu")) {
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
			if (arr[0].equals("Fri")) {
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
			if (arr[0].equals("Sat")) {
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
			if (arr[0].equals("Sun")) {
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
		if (arr[1].equals("Aug")) {
			if (arr[0].equals("Mon")) {
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
			if (arr[0].equals("Tue")) {
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
			if (arr[0].equals("Wed")) {
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
			if (arr[0].equals("Thu")) {
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
			if (arr[0].equals("Fri")) {
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
			if (arr[0].equals("Sat")) {
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
			if (arr[0].equals("Sun")) {
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
		if (arr[1].equals("Sep")) {
			if (arr[0].equals("Mon")) {
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
			if (arr[0].equals("Tue")) {
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
			if (arr[0].equals("Wed")) {
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
			if (arr[0].equals("Thu")) {
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
			if (arr[0].equals("Fri")) {
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
			if (arr[0].equals("Sat")) {
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
			if (arr[0].equals("Sun")) {
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
		if (arr[1].equals("Oct")) {
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
		if (arr[1].equals("Nov")) {
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
		if (arr[1].equals("Dec")) {
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

		/*
		 * 
		 * if(arr[0].equals("Tue")) { calc = Integer.parseInt(day) - 1; day = calc+""; }
		 * if(arr[0].equals("Wed")) { calc = Integer.parseInt(day) - 2; day = calc+""; }
		 * if(arr[0].equals("Thu")) { calc = Integer.parseInt(day) - 3; day = calc+""; }
		 * if(arr[0].equals("Fri")) { calc = Integer.parseInt(day) - 4; day = calc+"";;
		 * } if(arr[0].equals("Sat")) { calc = Integer.parseInt(day) - 5; day = calc+"";
		 * } if(arr[0].equals("Sun")) { calc = Integer.parseInt(day) - 6; day = calc+"";
		 * }
		 */

		if (Integer.parseInt(day) < 10) {
			day = "0" + day;

		}
		ans = year + "-" + month + "-" + day;

		return ans;

	}

	public boolean isCheckFood() {
		return checkFood;
	}

	public void setCheckFood(boolean checkFood) {
		this.checkFood = checkFood;
	}

	public boolean isCheckTransportation() {
		return checkTransportation;
	}

	public void setCheckTransportation(boolean checkTransportation) {
		this.checkTransportation = checkTransportation;
	}

	public boolean isCheckBeforeHours() {
		return checkBeforeHours;
	}

	public void setCheckBeforeHours(boolean checkBeforeHours) {
		this.checkBeforeHours = checkBeforeHours;
	}

	public boolean isCheckAfterHours() {
		return checkAfterHours;
	}

	public void setCheckAfterHours(boolean checkAfterHours) {
		this.checkAfterHours = checkAfterHours;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getCheckGrade() {
		return checkGrade;
	}

	public void setCheckGrade(String checkGrade) {
		this.checkGrade = checkGrade;
	}

	public String getCheckPrice() {
		return checkPrice;
	}

	public void setCheckPrice(String checkPrice) {
		this.checkPrice = checkPrice;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<SelectItem> getCampList() {
		return campList;
	}

	public void setCampList(List<SelectItem> campList) {
		this.campList = campList;
	}

	// public List<String> getActivities() {
	// return activities;
	// }

	// public void setActivities( List<String> activities) {
	// this.activities = activities;
	// }

	public void setCamps(List<Camp> camps) {
		this.camps = camps;
	}

	public String[] getSelectedCamps() {
		return selectedCamps;
	}

	public void setSelectedCamps(String[] selectedCamps) {
		this.selectedCamps = selectedCamps;
	}

	public String odkaz() {
		return "searchweb";
	}

	@PostConstruct
	public void init() {
		try {
			lazyModel = new LazyCamp(getCampsTest());
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(getZipCode() + "TOTO JE ZIP CODE INIT");
		campList = new ArrayList<SelectItem>();
		SelectItemGroup sport = new SelectItemGroup("Sports: ");
		sport.setSelectItems(new SelectItem[] { new SelectItem("Baseball", "Baseball"),
				new SelectItem("Soccer", "Soccer"), new SelectItem("Tennis", "Tennis") });

		SelectItemGroup art = new SelectItemGroup("Art: ");
		art.setSelectItems(new SelectItem[] { new SelectItem("Art", "Art"), new SelectItem("Drama", "Drama"),
				new SelectItem("Drawing", "Drawing"), new SelectItem("Painting", "Painting"),
				new SelectItem("Photography", "Photography"), new SelectItem("Music", "Music"),
				new SelectItem("Comedy", "Comedy"), new SelectItem("Theater", "Theater"),
				new SelectItem("Literature", "Literature"), new SelectItem("Film", "Film"),

		});
		SelectItemGroup general = new SelectItemGroup("General: ");
		general.setSelectItems(new SelectItem[] { new SelectItem("DayCamp", "DayCamp"),

		});
		SelectItemGroup stem = new SelectItemGroup("Stem: ");
		stem.setSelectItems(new SelectItem[] { new SelectItem("Stem", "Stem"),

		});

		campList.add(general);
		campList.add(stem);
		campList.add(art);
		campList.add(sport);

		camps = new ArrayList<Camp>();
		try {
			camps = getCampsTest();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onPageChange(PageEvent event) {

		this.setFirst(getFirst() + 1);
	}

	// This method is called to perform search
	public String submit() {
		this.setFirst(0);

		// Or in POST action method (e.g. <h:commandXxx action>).
		try {
			camps = getCampsTest();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String submit2() {
		this.setFirst(0);

		// Or in POST action method (e.g. <h:commandXxx action>).
		try {
			camps = getCampsTest();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "searchweb";
	}

	public String removeZipCode() {
		System.out.println("ZIP CODE METTHOD");
		System.out.println(getCheckRadius());
		setCheckRadius(getCheckRadius());
		System.out.println(getCheckRadius());
		try {
			camps = getCampsTest();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Search method for camps

	public List<Camp> getCampsTest() throws ClassNotFoundException, SQLException {

		camps = new ArrayList<Camp>();
		PreparedStatement ps = null;
		Connection con = null;
		String selectDistance = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_nshasano", "db_Spr19_nshasano",
					"nshasano");

		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
			System.out.println("NEIU WEBSITE JE DOLE");
		}

		if (getZipCode() != null) {
			if (!(getZipCode().equals(""))) {
				ps = con.prepareStatement("SELECT lat, lng FROM `P_Zipcode` WHERE zip = ?");
				ps.setString(1, getZipCode());

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					setCheckLat(rs.getString("lat"));
					setCheckLon(rs.getString("lng"));

				}
				selectDistance = "acos(sin(radians(" + getCheckLat() + "))*sin(radians(latitude)) + cos(radians("
						+ getCheckLat() + "))*cos(radians(latitude))*cos(radians(longitude) - radians(" + getCheckLon()
						+ "))) * 3959 As D, ";
			}
		}

		ps = con.prepareStatement(
				"SELECT DISTINCT c.campID, orgName, campName,street, city, state, zipcode, genderType, startDate, endDate, startHour, endHour, price, regStartDate , food, transportation, beforeCare, afterCare, latitude , longitude, ? GROUP_CONCAT(t.activity SEPARATOR ', ') as Activities   FROM P_Camp c,  P_Type t, P_Address a, P_Organization o, P_Gender g , P_CampType ct  where g.genderID = c.genderID and o.campOrgID = c.campOrgID and t.typeID = ct.typeID and ct.campID = c.campID and c.addressID = a.addressID");

		ps.setString(1, selectDistance);

		String s = ps + "";
		System.out.println("BEFORE: " + s);
		s = s.replaceFirst("\\'", "");
		s = s.replaceFirst("\\'", "");
		System.out.println("After : " + s);
		int position = s.indexOf("SELECT");
		System.out.println(position);

		s = s.substring(position);
		if (isCheckFood() == true)
			s += " and + c.food=" + isCheckFood();

		if (isCheckTransportation() == true)
			s += " and + c.transportation=" + isCheckTransportation();

		if (isCheckAfterHours() == true)
			s += " and + c.afterCare=" + isCheckAfterHours();

		if (isCheckBeforeHours() == true)
			s += " and + c.beforeCare=" + isCheckBeforeHours();

		if (getCheckType() != null) {
			if (!(getCheckType().equals("Type")))
				s += " and + t.activity='" + getCheckType() + "'";
		}

		if (getCheckGrade() != null) {
			if (!(getCheckGrade().equals("Grade"))) {
				s += " and + c.minGrade<=" + getCheckGrade();
				s += " and + c.maxGrade>=" + getCheckGrade();
			}
		}

		if (getCheckPrice() != null) {
			if (!(getCheckPrice().equals("Price")))
				s += " and + c.price<=" + getCheckPrice();
		}

		if (getZipCode() != null) {
			if (!(getZipCode().equals(""))) {
				selectDistance = selectDistance.substring(0, selectDistance.length() - 6);
				s += " and " + selectDistance + " < " + getCheckRadius();

			}
		}

		/*
		 * if(selectedCamps != null) { if(selectedCamps.length != 0 ) { s+=
		 * " and + ( t.activity='" + selectedCamps[0]+"'"; for(int i =1; i <
		 * selectedCamps.length; i++) { s+= " or + t.activity='" + selectedCamps[i]+"'";
		 * } s+= ")"; } }
		 */
		if (getCheckDate() != null) {
			s += " and + c.startDate='" + getDateMonday() + "'";
			System.out.println(getDateMonday());
		}

		s += " GROUP BY ct.campID";

		if (selectedCamps != null) {
			if (selectedCamps.length != 0) {
				s += " having (";
				s += " Activities like '%" + selectedCamps[0] + "%'";
				for (int i = 1; i < selectedCamps.length; i++) {
					s += " or Activities like '%" + selectedCamps[i] + "%'";
				}
				s += ")";
			}
		}

		if (getZipCode() != null) {
			if (!(getZipCode().equals(""))) {

				s += " Order By D";

			}
		}

		System.out.println(s);
		PreparedStatement pstmt = con.prepareStatement(s);
		ResultSet rs = pstmt.executeQuery();

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
			camp.setLatitude(rs.getString("latitude"));
			camp.setLongitude(rs.getString("longitude"));
			camp.setActivity(rs.getString("Activities"));
			camp.setStreet(rs.getString("street"));
			camp.setCity(rs.getString("city"));
			camp.setState(rs.getString("state"));
			camp.setZipcode(rs.getString("zipcode"));

			camps.add(camp);

		}

		// close resources
		rs.close();
		pstmt.close();
		con.close();

		return camps;

	}

	public List<Camp> getCamps() throws ClassNotFoundException, SQLException {

		return camps;

	}

	// Get list of activities for each camp
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

}