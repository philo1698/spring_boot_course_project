Spring Boot Project: Online Course Platform

PROJECT IDEA

A system where:

One Course contains many Lessons
Each Lesson belongs to one Course
ENTITIES
Course Entity

Attributes:

id (Long) -> Primary Key

title (String)

description (String)

instructorName (String)

price (Double)

createdAt (LocalDateTime)

Relationship:

One Course -> Many Lessons

Lesson Entity:

Attributes:

id (Long) -> Primary Key

title (String)

videoUrl (String)

duration (Integer) // in minutes

orderIndex (Integer)

Relationship:

Many Lessons -> One Course
course (Course) -> Foreign Key
RELATIONSHIP

Course (1) -------- (Many) Lesson

In code:

Course:
@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)

Lesson:
@ManyToOne
@JoinColumn(name = "course_id")

ENDPOINTS:

COURSE ENDPOINTS:

Create Course
POST /courses

Get Course by ID
GET /courses/{id}

Get All Courses
GET /courses

Update Course
PUT /courses/{id}

Delete Course
DELETE /courses/{id}

LESSON ENDPOINTS:

Add Lesson to Course
POST /courses/{courseId}/lessons

Get All Lessons for Course
GET /courses/{courseId}/lessons

Get Lesson by ID
GET /lessons/{id}

Update Lesson
PUT /lessons/{id}

Delete Lesson
DELETE /lessons/{id}
