package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	@Query("SELECT courseName,courseId as courseName FROM Course")
	List<String> findAllCourses();

	@Modifying
    @Query(
            value = "truncate table myTable",
            nativeQuery = true
    )
	void truncateMyTable();

}
