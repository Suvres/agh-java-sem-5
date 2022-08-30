CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE Student
(
    index     INTEGER      NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName  VARCHAR(255) NOT NULL,
    condition INTEGER      NOT NULL,
    birthDay  VARCHAR(255) NOT NULL,
    email     VARCHAR(255),
    CONSTRAINT pk_student PRIMARY KEY (index)
);

CREATE TABLE StudentCourse
(
    id               INTEGER NOT NULL,
    groupName        VARCHAR(255),
    maxStudentsCount DOUBLE PRECISION,
    CONSTRAINT pk_studentcourse PRIMARY KEY (id)
);

CREATE TABLE StudentMark
(
    id         INTEGER NOT NULL,
    student_id INTEGER,
    mark       DOUBLE PRECISION,
    date       TIMESTAMP WITHOUT TIME ZONE,
    course_id  INTEGER,
    CONSTRAINT pk_studentmark PRIMARY KEY (id)
);

ALTER TABLE StudentMark
    ADD CONSTRAINT FK_STUDENTMARK_ON_COURSE FOREIGN KEY (course_id) REFERENCES StudentCourse (id);

ALTER TABLE StudentMark
    ADD CONSTRAINT FK_STUDENTMARK_ON_STUDENT FOREIGN KEY (student_id) REFERENCES Student (index);