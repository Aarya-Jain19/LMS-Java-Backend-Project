package com.capgemini.lms.model.service;

import com.capgemini.lms.dto.EnrollmentDTO;
import com.capgemini.lms.exception.ResourceNotFoundException;
import com.capgemini.lms.feign.CourseClient;
import com.capgemini.lms.model.entity.*;
import com.capgemini.lms.model.repository.EnrollmentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository repo;
    private final CourseClient courseClient;

    public Enrollment enroll(EnrollmentDTO dto) {

        // Check if already enrolled
        if (repo.existsByUserIdAndCourseId(dto.getUserId(), dto.getCourseId())) {
            throw new RuntimeException("User already enrolled in this course");
        }

        // Check course exists (Feign call)
        try {
            courseClient.getCourseById(dto.getCourseId());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Course not found");
        }

        Enrollment e = new Enrollment();
        e.setUserId(dto.getUserId());
        e.setCourseId(dto.getCourseId());
        e.setStatus(EnrollmentStatus.ACTIVE);
        e.setProgressPercent(0);

        return repo.save(e);
    }

    public Enrollment updateProgress(Long id, Integer percent) {

        Enrollment e = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));

        e.setProgressPercent(percent);

        if (percent >= 100) {
            e.setStatus(EnrollmentStatus.COMPLETED);
        }

        return repo.save(e);
    }

    public List<Enrollment> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}