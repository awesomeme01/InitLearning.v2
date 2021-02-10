package com.init.learningPlatform.model;

import com.init.learningPlatform.helper.CourseStatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_init_1")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title", unique = false, length = 50,nullable = false)
    private String title;
    @Column(name = "startDate", unique = false, length = 50,nullable = false)
    private LocalDateTime startDate;
    @Column(name = "duration", unique = false, length = 50,nullable = false)
    private Double duration;
    @Column(name = "status", unique = false, length = 50,nullable = false)
    private CourseStatusEnum status;

    public Course() {
        this.status = CourseStatusEnum.PLANNING;
    }

    public Course(String title, LocalDateTime startDate, Double duration, CourseStatusEnum status) {
        this.title = title;
        this.startDate = startDate;
        this.duration = duration;
        this.status = status;
    }
}
