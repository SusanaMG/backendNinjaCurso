package com.udemy.repository;

//NO FUNCIONA AÑADIR LA LIBRERIA QUERYSDL pero dejo el código aquí
/*
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	
	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public void find() {
		
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		//Se trae todas las columnas
		Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

		//Se trae las columnas de nombre y descripción
		Course course2 = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

		//Devuelve un listado de registros
		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
	}
	
	public Course find2(boolean exist) {
		
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		//El where depende de un if
			//BooleanBuilder predicateBuilder = new BooleanBuilder(initial);
			//Predicate predicate1 = qCourse.description.endsWith("OP");
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		if(exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
	}
}
*/