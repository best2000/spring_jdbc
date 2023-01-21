CREATE TABLE course (
    id integer identity NOT NULL,
    title varchar(80) NOT NULL,
    teacher_id integer NOT NULL,
    CONSTRAINT pk_course_id PRIMARY KEY (id)
);

CREATE TABLE teacher (
    id integer identity NOT NULL,
    name varchar(80) NOT NULL,
    CONSTRAINT pk_teacher_detail_id PRIMARY KEY (id)
);