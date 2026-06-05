package com.capgemini.lms.controller;

import com.capgemini.lms.dto.EnrollmentDTO;
import com.capgemini.lms.model.entity.Enrollment;
import com.capgemini.lms.model.service.EnrollmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService service;

    @PostMapping
    public Enrollment enroll(@Valid @RequestBody EnrollmentDTO dto) {
        return service.enroll(dto);
    }

    @PatchMapping("/{id}/progress")
    public Enrollment updateProgress(
            @PathVariable Long id,
            @RequestParam Integer percent) {
        return service.updateProgress(id, percent);
    }

    @GetMapping("/user/{userId}")
    public List<Enrollment> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }
}