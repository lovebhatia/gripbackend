package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Topics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "topic_id")
	private  long topicId;
	@Column(name = "topic_name")
	private String topicName;

	@OneToMany(mappedBy = "topics", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<SubTopics> topicsSet=new HashSet<SubTopics>();

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="courseId")
	@JsonBackReference
	private Course course;

	public long getTopicId() {
		return topicId;
	}
	public void setTopicId(	long topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Set<SubTopics> getTopicsSet() {
		return topicsSet;
	}
	public void setTopicsSet(Set<SubTopics> topicsSet) {
		this.topicsSet = topicsSet;
	}


}

