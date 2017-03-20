package hust.edu.vn.rateict.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hust.edu.vn.rateict.dao.LocationDao;
import hust.edu.vn.rateict.model.Location;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);

//		Location alocation = new Location();
		
		List<Location> locationList = locationDao.getAllLocation();
		System.out.println(locationList);
	}
}