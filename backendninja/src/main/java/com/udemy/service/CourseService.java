package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

public interface CourseService {
	/* arreglado */
	public abstract List<CourseModel> listAllCourses();
	/* arreglado */
	public abstract CourseModel addCourse(CourseModel courseModel);
	/* arreglado */
	public abstract void removeCourse(int id);
	/* arreglado */
	public abstract Course findCourseById(int id);
	
	public abstract CourseModel updateCourse(CourseModel courseModel);
	
	public abstract Course findCourseByName(String name);
}
