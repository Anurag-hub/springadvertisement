package com.springdata.topicController;

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
public class TopicController {
		@Autowired
		private TopicList tl;

	@RequestMapping("/topics")
	public List<Topic> topic() {
	return tl.getAllTopic();
	}
	@RequestMapping("/topics/{name}")
	public Topic findTopic(@PathVariable String name) {
		return tl.searchTopic(name);
	}
	@RequestMapping(method=RequestMethod.POST, value=("/topics"))
	public void addNewTopic(@RequestBody Topic t2) {
		tl.addTopic(t2);
	}
	@RequestMapping(method=RequestMethod.PUT, value=("/topics/{name}"))
	public void UpdateTopic(@RequestBody Topic t2,@PathVariable String name) {
		tl.UpdateExistingTopic(t2,name);
}
	@RequestMapping(method=RequestMethod.DELETE, value=("/topics/{name}"))
	public void DeleteTopic(@PathVariable String name) {
		tl.DeleteExistingTopic(name);
}
}
