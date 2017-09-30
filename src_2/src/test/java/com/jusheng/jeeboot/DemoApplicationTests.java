package com.jusheng.jeeboot;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@MapperScan("com.jusheng.jeeboot.dao")
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

	}

}
