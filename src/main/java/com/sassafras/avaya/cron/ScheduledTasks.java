package com.sassafras.avaya.cron;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sassafras.avaya.email.PackagingAttchment;
import com.sassafras.avaya.email.SendEmail;

/**
 * 设置定时任务
 * @author WuChenghao
 *
 */
@Component
public class ScheduledTasks {

	private static final Logger logger= Logger.getLogger(ScheduledTasks.class);

	@Autowired
	private PackagingAttchment pa;

	@Autowired
	private SendEmail se;
	
	@Scheduled(cron="20 28 17 ? * *")
	public void Task() {
		logger.info("before task");
		pa.getExcel();
		se.sendSimpleMail();
//		Util.delete(pa.getAttchmentName());
		logger.info("end task");
	}

}
