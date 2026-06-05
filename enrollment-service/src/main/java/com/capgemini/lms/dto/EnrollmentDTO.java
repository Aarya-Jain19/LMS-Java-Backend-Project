package com.capgemini.lms.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnrollmentDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long courseId;
}