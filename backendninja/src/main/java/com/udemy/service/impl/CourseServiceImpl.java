package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;



@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;
	

	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("Call: " + "listAllCourses()"); 
		List<Course> courses = courseJpaRepository.findAll();
		List<CourseModel> coursesModel = new ArrayList<CourseModel>();
		for (Course course : courses) {
			coursesModel.add(courseConverter.entity2model(course));			
			LOG.info("El courseModel de la lista es: " + (courseConverter.entity2model(course)).toString());
		}
		return coursesModel;
	}

	@Override
	public CourseModel addCourse(CourseModel courseModel) {
		LOG.info("El courseModel es: " + courseModel.toString());
		Course course = courseJpaRepository.save(courseConverter.model2entity(courseModel));
		LOG.info("El course es: " + course.toString());
		LOG.info("Call in ServiceImpl: " + "addCourse()"); 
		LOG.info("Tras convertir el coursemodel es: " + (courseConverter.entity2model(course)).toString());
		return courseConverter.entity2model(course);
	}

	@Override
	public Course findCourseById(int id) {
		return courseJpaRepository.findById(id);	
	}
	
	@Override
	public void removeCourse(int id) {
		LOG.info("Call in ServiceImpl: " + "removeCourse()");
		Course course = findCourseById(id);
		if (course != null) {
			courseJpaRepository.deleteById(id);
		}
	}

	@Override
	public Course findCourseByName(String name) {
		return courseJpaRepository.findByName(name);
	}
	
	@Override
	public CourseModel updateCourse(CourseModel courseModel) {
		LOG.info("Call in ServiceImpl: " + "updateCourse()");
		Course courseEncontrado = findCourseByName(courseModel.getName());
		Course course = null;
		if (courseEncontrado != null) {
			LOG.info("El curso encontrado en ServiceImpl es: " + courseEncontrado.toString() + " id: " + courseEncontrado.getId());
			course = courseConverter.model2entity(courseModel);
			course.setId(courseEncontrado.getId());	
			courseJpaRepository.save(course);
		}	
		return courseConverter.entity2model(course);
	}

	
}
