package com.capgemini.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Instructor ID is required")
    private Long instructorId;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Price is required")
    private Double price;
}