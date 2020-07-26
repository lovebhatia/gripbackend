package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.SubTopics;

public interface SubTopicRepository extends JpaRepository<SubTopics, Long> {
	@Query(value = "SELECT sub_topic_name,sub_topic_id FROM  sub_topics WHERE  topic_id = :TopicId", nativeQuery = true)
	List<String> findSubTopicByTopic(@Param("TopicId") Long TopicId);

}
