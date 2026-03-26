package com.ph.courseapp.controllers;

import com.ph.courseapp.models.DTO.courseDTO;
import com.ph.courseapp.services.courseService;
import com.ph.courseapp.models.DAO.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class courseController {
    @Autowired
    private courseService courseService;

    // CREATE
    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // GET ALL
    @GetMapping("/getCourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // GET BY ID
    @GetMapping("/get")
    public Course getCourseById(@RequestBody Long id) {
        return courseService.getCourseById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody courseDTO dto) {

        Course updated = new Course();
        updated.setTitle(dto.getTitle());
        updated.setDescription(dto.getDescription());
        updated.setInstructorName(dto.getInstructorName());
        updated.setPrice(dto.getPrice());
        updated.setCreatedAt(dto.getCreatedAt());

        return courseService.updateCourse(id, updated);

    }

    // DELETE
    @DeleteMapping("/delete")
    public String deleteCourse(@RequestBody Long id) {
        return courseService.deleteCourse(id);
    }

}
