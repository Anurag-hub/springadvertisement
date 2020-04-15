package com.springdata.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
		@Autowired
		private CourseList tl;

	@RequestMapping("/topics/{Topicname}/course")
	public List<Course> topic() {
	return tl.getAllCourse();
	}
	@RequestMapping("/topics/{Topicname}/course/{Coursename}")
	public Course findTopic(@PathVariable String name) {
		return tl.searchCourse(name);
	}
	@RequestMapping(method=RequestMethod.POST, value=("/topics/{Topicname}/course"))
	public void addNewTopic(@RequestBody Course t2) {
		tl.addCourse(t2);
	}
	@RequestMapping(method=RequestMethod.PUT, value=("/topics/{name}"))
	public void UpdateTopic(@RequestBody Course t2,@PathVariable String name) {
		tl.UpdateExistingCourse(t2,name);
}
	@RequestMapping(method=RequestMethod.DELETE, value=("/topics/{name}"))
	public void DeleteTopic(@PathVariable String name) {
		tl.DeleteExistingTopic(name);
}
}
