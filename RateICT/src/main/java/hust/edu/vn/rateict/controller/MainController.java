package hust.edu.vn.rateict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hust.edu.vn.rateict.dao.LocationDao;
import hust.edu.vn.rateict.model.Location;

@Controller
public class MainController {

	@Autowired
	private LocationDao locationDao;

	@RequestMapping("/")
	public String homePage(Model model) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);
		
		List<Location> locationList = locationDao.getAllLocation();
		model.addAttribute("locationlist", locationList);
		return "home"; 
	}
}
