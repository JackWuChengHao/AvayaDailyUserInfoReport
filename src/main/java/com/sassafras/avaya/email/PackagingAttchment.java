package com.sassafras.avaya.email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import com.github.crab2died.sheet.wrapper.NoTemplateSheetWrapper;
import com.sassafras.avaya.dao.Query;
import com.sassafras.avaya.entity.AvayaUserInfo;
import com.sassafras.avaya.entity.UserQuantity;
import com.sassafras.avaya.utils.Util;


/**
 * 用于生成excel报表
 * @author WuChenghao
 *
 */
@Component
public class PackagingAttchment {

	private final static Logger logger =  Logger.getLogger(PackagingAttchment.class);

	{
		this.AttchmentName = new StringBuilder().append("Avaya_User_Report_").append(Util.getFileSuffix()).append(".xls").toString();
	}

	@Autowired
	private Query qe;

	private String AttchmentName;

	public String getAttchmentName() {
		return AttchmentName;
	}

	public void setAttchmentName(String attchmentName) {
		AttchmentName = attchmentName;
	}

	public void getExcel() {

		List<AvayaUserInfo> userinfo_list = qe.getUserInfo();
		
		List<UserQuantity> user_list = qe.getUserAcc();
		
		if(Objects.isNull(userinfo_list) || Objects.isNull(user_list))
			return;
		
		List<NoTemplateSheetWrapper> sheets = new ArrayList<NoTemplateSheetWrapper>();

		sheets.add(new NoTemplateSheetWrapper(userinfo_list,AvayaUserInfo.class,true,"Avaya User Info"));
		
		logger.info("******************"+user_list.size());
		
		sheets.add(new NoTemplateSheetWrapper(user_list,UserQuantity.class,true,"User Quantity"));
		
		try {
			ExcelUtils.getInstance().noTemplateSheet2Excel(sheets, false, AttchmentName);
		} catch (Excel4JException | IOException e) {
			logger.error(e);
		}
	}


}
