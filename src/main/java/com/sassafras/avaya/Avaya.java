package com.sassafras.avaya;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 程序主入口，并设置全局功能开关
 * @author WuChenghao
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.sassafras.*"})
@EnableScheduling
public class Avaya {
	
	private final static Logger logger =  Logger.getLogger(Avaya.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Avaya.class, args);
		logger.info("the application is running");
	}
	
}
