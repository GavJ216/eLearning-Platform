BEGIN TRANSACTION;

INSERT INTO users (first_name,last_name,username,password_hash,role) VALUES ('admin','account','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (first_name,last_name,username,password_hash,role) VALUES ('manager','account','manager','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_MANAGER');
INSERT INTO users (first_name,last_name,username,password_hash,role) VALUES ('user','account','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO course (course_name,course_description, difficulty, cost) VALUES ('sample_course','this is a course','very difficult', 100);
INSERT INTO course (course_name,course_description, difficulty, cost) VALUES ('sample_course2','this is another course','easy peasy', 0);

COMMIT TRANSACTION;



BEGIN TRANSACTION;

INSERT INTO users_course (user_id,course_id) VALUES (1,1),(2,1);
INSERT INTO users_course (user_id,course_id) VALUES (1,2);

INSERT INTO lesson (course_id,lesson_name,lesson_description) VALUES (1,'imma teach you a lesson','this is a lesson about teaching you about lessons');
INSERT INTO lesson (course_id,lesson_name,lesson_description) VALUES (2,'less son','more daughter');

INSERT INTO quiz (lesson_id,quiz_name,quiz_description) VALUES (1,'sample course Quiz #1','this quiz is a doozy');
INSERT INTO quiz (lesson_id,quiz_name,quiz_description) VALUES (2,'sample course2 Quiz #1','this quiz is a piece of cake');

COMMIT TRANSACTION;
