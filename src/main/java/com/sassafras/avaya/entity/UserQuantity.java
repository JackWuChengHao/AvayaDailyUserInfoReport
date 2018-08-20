package com.sassafras.avaya.entity;

import org.springframework.stereotype.Component;

import com.github.crab2died.annotation.ExcelField;

@Component
public class UserQuantity {

	@ExcelField(title = "Date", order = 1)
	private String date;

	@ExcelField(title = "Day", order = 2)
	private String day;

	@ExcelField(title = "Month", order = 3)
	private String month;

	@ExcelField(title = "Year", order = 4)
	private String year;

	@ExcelField(title = "Location", order = 5)
	private String location;

	@ExcelField(title = "Department", order = 6)
	private String  department;

	@ExcelField(title = "Site", order = 7)
	private String site;

	@ExcelField(title = "Profile", order = 8)
	private String profileName;

	@ExcelField(title = "Quantity", order = 9)
	private Integer quantity;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "UserQuantity [date=" + date + ", day=" + day + ", month=" + month + ", year=" + year + ", location="
				+ location + ", department=" + department + ", site=" + site + ", profileName=" + profileName
				+ ", quantity=" + quantity + "]";
	}

}
