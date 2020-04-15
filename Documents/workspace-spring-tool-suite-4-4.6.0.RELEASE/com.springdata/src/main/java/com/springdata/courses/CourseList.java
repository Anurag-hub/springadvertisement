package com.springdata.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseList {
	@Autowired
	private CourseRepository courserepository;
	
	List<Course> t=new ArrayList<>(Arrays.asList(new Course(1,"anurag","good"),
			 new Course(2,"kumar","very good"),
			 new Course(3,"pandey","very very good")));

	public List<Course> getAllCourse(){
		List<Course> courses=new ArrayList<Course>();
		courserepository.findAll().forEach(courses::add);
		return courses;
	}
	public Course searchCourse(String name){
		return t.stream().filter(t1 -> t1.getName().equals(name)).findFirst().get();
	}
	public void addCourse(Course t2) {
		courserepository.save(t2);
	}
	public void UpdateExistingCourse(Course t2,String name) {
		Course t4=t.stream().filter(t3 ->t3.getName().equals(name)).findFirst().get();
		t4.setId(t2.getId());
		t4.setDescription(t2.getDescription());
		t4.setName(t2.getName());
		
	}
	public void DeleteExistingTopic(String name) {
		Course t5=t.stream().filter(t6 ->t6.getName().equals(name)).findFirst().get();
		t.remove(t5);
	}
}

