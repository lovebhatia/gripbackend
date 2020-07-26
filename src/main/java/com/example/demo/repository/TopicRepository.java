package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Topics;

public interface TopicRepository extends JpaRepository<Topics, Long> {
	@Query(value = "SELECT topic_Name,topic_id FROM  topics WHERE  course_Id = :CourseId", nativeQuery = true)
	List<String> findTopicByCourse(@Param("CourseId") Long courseId);
	 
	
	
}
