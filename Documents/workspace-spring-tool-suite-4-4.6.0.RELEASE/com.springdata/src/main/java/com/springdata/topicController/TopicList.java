package com.springdata.topicController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicList {
	@Autowired
	private TopicRepository topicrepository;
	
	List<Topic> t=new ArrayList<>(Arrays.asList(new Topic(1,"anurag","good"),
			 new Topic(2,"kumar","very good"),
			 new Topic(3,"pandey","very very good")));

	public List<Topic> getAllTopic(){
		List<Topic> topics=new ArrayList<Topic>();
		topicrepository.findAll().forEach(topics::add);
		return topics;
	}
	public Topic searchTopic(String name){
		return t.stream().filter(t1 -> t1.getName().equals(name)).findFirst().get();
	}
	public void addTopic(Topic t2) {
		topicrepository.save(t2);
	}
	public void UpdateExistingTopic(Topic t2,String name) {
		Topic t4=t.stream().filter(t3 ->t3.getName().equals(name)).findFirst().get();
		t4.setId(t2.getId());
		t4.setDescription(t2.getDescription());
		t4.setName(t2.getName());
		
	}
	public void DeleteExistingTopic(String name) {
		Topic t5=t.stream().filter(t6 ->t6.getName().equals(name)).findFirst().get();
		t.remove(t5);
	}
}

