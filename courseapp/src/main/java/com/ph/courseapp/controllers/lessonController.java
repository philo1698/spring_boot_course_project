package com.ph.courseapp.controllers;

import com.ph.courseapp.models.DAO.Lesson;
import com.ph.courseapp.models.DTO.lessonDTO;
import com.ph.courseapp.services.lessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class lessonController {
    @Autowired
    private lessonService lessonService;

    // ADD LESSON TO COURSE
    @PostMapping("/course/{courseId}/addLessons")
    public Lesson addLesson(@PathVariable Long courseId,
                            @RequestBody Lesson lesson) {

        return lessonService.addLesson(courseId, lesson);
    }

    // GET LESSONS BY COURSE
    @GetMapping("/course/getLessons")
    public List<Lesson> getLessonsByCourse(@RequestBody Long courseId) {
        return lessonService.getLessonsByCourse(courseId);
    }

    // GET LESSON BY ID
    @GetMapping("/lesson/get")
    public Lesson getLessonById(@RequestBody Long id) {
        return lessonService.getLessonById(id);

    }

    // UPDATE LESSON
    @PutMapping("/lesson/update/{id}")
    public Lesson updateLesson(@PathVariable Long id,
                               @RequestBody lessonDTO dto) {

        Lesson updated = new Lesson();
        updated.setTitle(dto.getTitle());
        updated.setVideoUrl(dto.getVideoUrl());
        updated.setDuration(dto.getDuration());
        updated.setOrderIndex(dto.getOrderIndex());
        updated.setCreatedAt(dto.getCreatedAt());

        return lessonService.updateLesson(id, updated);
    }

    // DELETE
    @DeleteMapping("/lesson/delete")
    public void deleteLesson(@RequestBody Long id) {
        lessonService.deleteLesson(id);
    }

}
