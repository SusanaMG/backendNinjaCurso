package com.udemy.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {
	
	public abstract Course findByPrice(int price);
	
	public abstract Course findByPriceAndName(int price, String name);

	public abstract List<Course> findByNameOrderByHours(String name);
	
	public abstract Course findByNameOrPrice(String name, int price);
	
	public abstract Course findById(int id);
	
	public abstract Course findByName(String name);

}
