BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO course (course_name,course_description, difficulty, cost) VALUES ('sample_course','this is a course','very difficult', 100);
INSERT INTO course (course_name,course_description, difficulty, cost) VALUES ('sample_course2','this is another course','easy peasy', 150);

INSERT INTO lesson (lesson_name, lesson_description) VALUES ('lesson1', 'You are going to learn today');
INSERT INTO lesson (lesson_name, lesson_description) VALUES ('lesson2', 'Gumba boo, gumba goo');





COMMIT TRANSACTION;
