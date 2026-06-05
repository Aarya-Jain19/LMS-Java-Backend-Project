package com.capgemini.lms.model.repositoryservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.lms.dto.CourseDTO;
import com.capgemini.lms.exception.ResourceNotFoundException;
import com.capgemini.lms.model.entity.Course;
import com.capgemini.lms.model.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {
	private final CourseRepository repo;

	public Course create(CourseDTO dto) {
		Course c = new Course(null, dto.getTitle(), dto.getDescription(), dto.getInstructorId(), dto.getCategory(),
				dto.getPrice());
		return repo.save(c);
	}

	public List<Course> getAll() {
		return repo.findAll();
	}

	public Course getById(Integer id) {
	    return repo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
	}

	public Course update(Integer id, CourseDTO dto) {
		Course c = getById(id);
		c.setTitle(dto.getTitle());
		c.setDescription(dto.getDescription());
		c.setPrice(dto.getPrice());
		return repo.save(c);
	}

	public void delete(Integer id) {
		Course course = getById(id); 
		repo.delete(course);
	}
}