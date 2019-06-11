package com.udemy.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final String COURSES_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new CourseModel());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()" + " -- Param: " + courseModel.toString());
		courseService.addCourse(courseModel);
		return "redirect:/courses/listcourses";
	}

	@GetMapping("/removecourse")
	public String removeCourse(int id) {
		LOG.info("Call from Controller: " + "removeCourse()");
		LOG.info("Parámetro recibido: " + id);
		courseService.removeCourse(id);
		return "redirect:/courses/listcourses";
	}

	@PostMapping("/updatecourse")
	public String updateCourse(@ModelAttribute("course") CourseModel courseModel) {
		LOG.info("Call: " + "updateCourse()" + " -- Param: " + courseModel.toString());
		courseService.updateCourse(courseModel);
		return "redirect:/courses/listcourses";
	}
	
	
	
	
	
}
