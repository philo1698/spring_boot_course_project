package com.ph.courseapp.services;

import com.ph.courseapp.models.DAO.Course;
import com.ph.courseapp.models.DAO.Lesson;
import com.ph.courseapp.repositories.CourseRepository;
import com.ph.courseapp.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class lessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Add Lesson to Course
    public Lesson addLesson(Long courseId, Lesson lesson) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) return null;

        lesson.setCourse(course);
        // DO NOT override createdAt
        return lessonRepository.save(lesson);
    }

    // Get Lessons by Course
    public List<Lesson> getLessonsByCourse(Long courseId) {
        return lessonRepository.findByCourseIdOrderByOrderIndexAsc(courseId);
    }

    // Get Lesson by ID
    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    // Update Lesson
    public Lesson updateLesson(Long id, Lesson updatedLesson) {
        Lesson lesson = lessonRepository.findById(id).orElse(null);
        if (lesson == null) return null;

        if (updatedLesson.getTitle() != null) lesson.setTitle(updatedLesson.getTitle());
        if (updatedLesson.getVideoUrl() != null) lesson.setVideoUrl(updatedLesson.getVideoUrl());
        if (updatedLesson.getDuration() != null) lesson.setDuration(updatedLesson.getDuration());
        if (updatedLesson.getOrderIndex() != null) lesson.setOrderIndex(updatedLesson.getOrderIndex());
        if (updatedLesson.getCreatedAt() != null) lesson.setCreatedAt(updatedLesson.getCreatedAt()); // take date from input

        return lessonRepository.save(lesson);
    }

    // Delete Lesson
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
