package com.capgemini.lms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseClient {
    @GetMapping("/courses/{id}")
    CourseClient getCourseById(@PathVariable Long id);
}