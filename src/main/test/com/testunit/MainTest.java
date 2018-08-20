package com.testunit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sassafras.avaya.dao.Query;
import com.sassafras.avaya.entity.UserQuantity;
import com.sassafras.avaya.utils.Util;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations={"classpath:application.yml"})
public class MainTest {

	@Autowired
	private Query query;

	@Test
	public void testUtil() {
		System.out.println(Util.getCurrentTimeByFormatString("M"));
		System.out.println(Util.getCurrentTimeByFormatString("d"));
		System.out.println(Util.getCurrentTimeByFormatString("yyyy/M/d"));
	}
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetUserinfo() {

		for(UserQuantity user : query.getUserAcc()) {
			System.out.println(user.getQuantity());
		}

	}


}
