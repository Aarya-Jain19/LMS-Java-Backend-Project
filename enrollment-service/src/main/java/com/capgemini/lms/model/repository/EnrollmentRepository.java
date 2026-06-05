package com.capgemini.lms.model.repository;

import com.capgemini.lms.model.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByUserId(Long userId);

    boolean existsByUserIdAndCourseId(Long userId, Long courseId);
}