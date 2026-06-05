package com.capgemini.lms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.dto.CourseDTO;
import com.capgemini.lms.model.entity.Course;
import com.capgemini.lms.model.repositoryservice.CourseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
	private final CourseService service;

	@PostMapping
	public ResponseEntity<Course> create(@RequestBody @Valid CourseDTO dto) {
		return ResponseEntity.status(201).body(service.create(dto));
	}

	@GetMapping
	public List<Course> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Course getById(@PathVariable Integer id) {
		return service.getById(id);
	}

	@PutMapping("/{id}")
	public Course update(@PathVariable Integer id, @RequestBody CourseDTO dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}