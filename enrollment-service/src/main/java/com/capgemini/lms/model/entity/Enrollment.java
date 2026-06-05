package com.capgemini.lms.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enrollments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long userId;
    @NotNull 
    private Long courseId;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;    // ACTIVE, COMPLETED, DROPPED

    private Integer progressPercent;    // 0–100
    private LocalDateTime enrolledAt;

    @PrePersist
    public void prePersist() { enrolledAt = LocalDateTime.now(); }
}