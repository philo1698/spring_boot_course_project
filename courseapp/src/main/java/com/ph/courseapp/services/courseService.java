package com.ph.courseapp.services;

import com.ph.courseapp.models.DAO.Course;
import com.ph.courseapp.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseService {
    @Autowired
    private CourseRepository courseRepository;

    // Create Course
    public Course createCourse(Course course) {
        // Do NOT override createdAt, use the one passed
        return courseRepository.save(course);
    }

    // Get All Courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get Course by ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Update Course
    public Course updateCourse(Long id, Course updatedCourse) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) return null;

        if (updatedCourse.getTitle() != null) course.setTitle(updatedCourse.getTitle());
        if (updatedCourse.getDescription() != null) course.setDescription(updatedCourse.getDescription());
        if (updatedCourse.getInstructorName() != null) course.setInstructorName(updatedCourse.getInstructorName());
        if (updatedCourse.getPrice() != null) course.setPrice(updatedCourse.getPrice());
        if (updatedCourse.getCreatedAt() != null) course.setCreatedAt(updatedCourse.getCreatedAt()); // take date from input

        return courseRepository.save(course);
    }

    // Delete Course
    public String deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return "course deleted successfully";
    }
}
