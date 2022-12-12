BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, course, users_course, lesson, quiz;

CREATE TABLE users (
	user_id SERIAL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE course (
	course_id SERIAL,
	course_name varchar(100) NOT NULL UNIQUE,
	course_description varchar(2000) NOT NULL,
	difficulty varchar(20) NOT NULL,
	cost numeric DEFAULT 0.00,
	CONSTRAINT PK_course PRIMARY KEY (course_id)
);

CREATE TABLE users_course (
	user_id int,
	course_id int,
	progress varchar(50) DEFAULT 'Not Started',
	CONSTRAINT FK_users FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT FK_course FOREIGN KEY (course_id) REFERENCES course(course_id)
);

CREATE TABLE lesson (
	lesson_id SERIAL,
	course_id int,
	lesson_name varchar(100) NOT NULL UNIQUE,
	lesson_description varchar(2000) NOT NULL,
	CONSTRAINT PK_lesson PRIMARY KEY (lesson_id),
	CONSTRAINT FK_course FOREIGN KEY (course_id) REFERENCES course(course_id)

);

CREATE TABLE quiz (
	quiz_id SERIAL,
	lesson_id int,
	quiz_name varchar(100) NOT NULL,
	quiz_description varchar(2000) NOT NULL,
	CONSTRAINT PK_quiz PRIMARY KEY (quiz_id),
	CONSTRAINT FK_lesson FOREIGN KEY (lesson_id) REFERENCES lesson(lesson_id)

);

COMMIT TRANSACTION;