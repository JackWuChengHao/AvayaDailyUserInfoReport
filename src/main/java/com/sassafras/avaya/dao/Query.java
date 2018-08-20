package com.sassafras.avaya.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sassafras.avaya.entity.AvayaUserInfo;
import com.sassafras.avaya.entity.UserQuantity;
import com.sassafras.avaya.utils.Util;

/**
 * 连接数据库获取查询结果
 * @author WuChenghao
 *
 */
@Component
public class Query {

	private final static Logger logger =  Logger.getLogger(Query.class);

	@Autowired
	private DataSource dataSource;

	public List<AvayaUserInfo> getUserInfo() {

		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		List<AvayaUserInfo> qr_list = new ArrayList<AvayaUserInfo>();

		String query = "select u.user_name , u.user_first_name , u.user_last_name, u.user_extension, u.agent_id, up.profileName,"
				+ "u.User_SipUri, g.group_name as team, s.segment_name as department, sts.site_name, l.location_name from ACCCM.dbo.Users u " + 

				"left join ACCCM.dbo.Users_Groups ug on u.user_id = ug.user_id " + 

				"left join ACCCM.dbo.Groups g on g.group_id = ug.group_id " + 

				"left join ACCCM.dbo.segments_groups sg on sg.group_id = ug.group_id " + 

				"left join ACCCM.dbo.segments s on s.segment_id = sg.segment_id " + 

				"left join ACCCM.dbo.sites_segments ss on ss.segment_id = s.segment_id " + 

				"left join ACCCM.dbo.sites sts on sts.site_id = ss.site_id " + 

				"left join ACCCM.dbo.locations l on l.location_id = sts.location " + 

				"left join ACCCM.dbo.UserProfiles up on u.user_profile = up.ProfileId order by user_name";

		try {
			connection = dataSource.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(query);

			if(Objects.isNull(rs)) {
				logger.info("ResultSet is null");
				return qr_list;
			}

			while(rs.next()){
				AvayaUserInfo qr = new AvayaUserInfo();
				qr.setUser_name(rs.getString(1));
				qr.setUser_first_name(rs.getString(2));
				qr.setUser_last_name(rs.getString(3));
				qr.setUser_extension(rs.getString(4));
				qr.setAgent_id(rs.getLong(5));
				qr.setProfileName(rs.getString(6));
				qr.setUser_SipUri(rs.getString(7));
				qr.setTeam(rs.getString(8));
				qr.setDepartment(rs.getString(9));
				qr.setSite_name(rs.getString(10));
				qr.setLocation_name(rs.getString(11));
				qr_list.add(qr);
			}
		} catch (SQLException e) {
			logger.info(e);
		}	finally {
			if(Objects.nonNull(connection))
				Util.closeConnection(connection);
			if(Objects.nonNull(st))
				Util.closeStatement(st);
		}
		return qr_list;
	}


	public List<UserQuantity>   getUserAcc(){
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		List<UserQuantity> qr_list = new ArrayList<UserQuantity>();

		String query = "SELECT "+
				"s.segment_name as department,  " +
				"l.Location_Name as Location, "+
				"sts.site_name AS  Site , "+
				"up.profileName AS Profile, "+
				" COUNT(u.User_Id) AS Quantity "+
				"FROM "+
				"ACCCM.dbo.Users u "+
				"LEFT JOIN ACCCM.dbo.Users_Groups ug ON u.user_id = ug.user_id "+
				"LEFT JOIN ACCCM.dbo.Groups g ON g.group_id = ug.group_id "+
				"LEFT JOIN ACCCM.dbo.segments_groups sg ON sg.group_id = ug.group_id "+
				"LEFT JOIN ACCCM.dbo.segments s ON s.segment_id = sg.segment_id "+
				"LEFT JOIN ACCCM.dbo.sites_segments ss ON ss.segment_id = s.segment_id "+
				"LEFT JOIN ACCCM.dbo.sites sts ON sts.site_id = ss.site_id "+
				"LEFT JOIN ACCCM.dbo.locations l ON l.location_id = sts.location "+
				"LEFT JOIN ACCCM.dbo.UserProfiles up ON u.user_profile = up.ProfileId "+
				"Group BY l.Location_Name,s.segment_name,sts.site_name,up.profileName "+
				"ORDER BY l.Location_Name,s.segment_name,sts.site_name,up.profileName,Quantity";

		try {
			connection = dataSource.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(query);

			if(Objects.isNull(rs)) {
				logger.info("ResultSet is null");
				return qr_list;
			}

			String date = Util.getCurrentTimeByFormatString("yyyy/M/d");
			String day = Util.getCurrentTimeByFormatString("d");
			String month = Util.getCurrentTimeByFormatString("M");
			String year = Util.getCurrentTimeByFormatString("yyyy");

			while(rs.next()){
				UserQuantity qr = new UserQuantity();
				qr.setDate(date);
				qr.setDay(day);
				qr.setMonth(month);
				qr.setYear(year);
				qr.setDepartment(rs.getString(1));
				qr.setLocation( rs.getString(2));
				qr.setSite( rs.getString(3));
				qr.setProfileName( rs.getString(4));
				qr.setQuantity(rs.getInt(5));
				qr_list.add(qr);
			}
		} catch (SQLException e) {
			logger.info(e);
		}	finally {
			if(Objects.nonNull(connection))
				Util.closeConnection(connection);
			if(Objects.nonNull(st))
				Util.closeStatement(st);
		}
		return qr_list;
	}


}
