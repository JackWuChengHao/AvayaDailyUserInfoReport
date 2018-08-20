package com.sassafras.avaya.entity;

import org.springframework.stereotype.Component;

import com.github.crab2died.annotation.ExcelField;

@Component
public class  AvayaUserInfo {
	
	@ExcelField(title = "Name", order = 1)
	private String user_name;
	
	@ExcelField(title = "FirstName", order = 2)
	private String user_first_name;
	
	@ExcelField(title = "Last_Name", order = 3)
	private String user_last_name;
	
	@ExcelField(title = "Extension", order = 4)
	private String user_extension;
	
	@ExcelField(title = "Ggent", order = 5)
	private Long agent_id;
	
	@ExcelField(title = "Profile", order = 6)
	private String  profileName;
	
	@ExcelField(title = "SipUri", order = 7)
	private String user_SipUri;
	
	@ExcelField(title = "Team", order = 8)
	private String team;
	
	@ExcelField(title = "Department", order = 9)
	private String department;
	
	@ExcelField(title = "Site_name", order = 10)
	private String site_name;
	
	@ExcelField(title = "Location", order = 11)
	private String location_name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_extension() {
		return user_extension;
	}

	public void setUser_extension(String user_extension) {
		this.user_extension = user_extension;
	}


	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getUser_SipUri() {
		return user_SipUri;
	}

	public void setUser_SipUri(String user_SipUri) {
		this.user_SipUri = user_SipUri;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public Long getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(Long agent_id) {
		this.agent_id = agent_id;
	}

	@Override
	public String toString() {
		return "QueryResult [user_name=" + user_name + ", user_first_name=" + user_first_name + ", user_last_name="
				+ user_last_name + ", user_extension=" + user_extension + ", agent_id=" + agent_id + ", profileName="
				+ profileName + ", user_SipUri=" + user_SipUri + ", team=" + team + ", department=" + department
				+ ", site_name=" + site_name + ", location_name=" + location_name + "]";
	}

	
}
