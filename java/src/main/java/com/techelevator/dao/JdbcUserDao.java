package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.techelevator.model.Course;
import com.techelevator.model.CourseListDto;
import com.techelevator.model.UserCourseDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        int userId;
        try {
            userId = jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + username + " was not found.");
        }

        return userId;
    }

	@Override
	public User getUserById(int userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if (results.next()) {
			return mapRowToUser(results);
		} else {
			return null;
		}
	}

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        for (User user : this.findAll()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public User create(String firstName, String lastName, String password, String role) {
        String username = firstName.charAt(0) + lastName;
        String insertUserSql = "insert into users (first_name,last_name,username,password_hash,role) values (?,?,?,?,?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();
        jdbcTemplate.update(insertUserSql, firstName, lastName, username, password_hash, ssRole);
        User userToUpdate = this.findByUsername(username);
        String updateUsernameSql = "UPDATE users SET username = ? WHERE user_id = ?";
        String setUsername = username + userToUpdate.getId();
        jdbcTemplate.update(updateUsernameSql, setUsername, userToUpdate.getId());

        return this.getUserById(userToUpdate.getId());
    }

    @Override
    public List<UserCourseDto> getUsersByCourseId(int courseId){
        List<UserCourseDto> users = new ArrayList<>();
        String sql = "select * from users " +
                "join users_course on users_course.user_id = users.user_id WHERE course_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        while (results.next()) {
            UserCourseDto johnnyboi = new UserCourseDto(mapRowToUser(results), results.getDouble("progress"));
            users.add(johnnyboi);
        }

        return users;
    }

    @Override
    public boolean addUserToCourse(int userId, int courseId) {
        String sql = "INSERT INTO users_course (user_id, course_id) " +
                "VALUES (?, ?) RETURNING user_id;";
        jdbcTemplate.queryForObject(sql, Integer.class, userId, courseId );


        return true;

    }

    @Override
    public void makeAdmin(String username) {

        String sql = "UPDATE users SET role = 'ROLE_ADMIN' WHERE username = ?;";
        jdbcTemplate.update(sql,username);

    }

    @Override
    public void markLessonCompleted(int lessonId, int userId) {
        if (!this.checkLessonCompletion(lessonId, userId)) {
            String sql = "INSERT INTO lesson_users(lesson_id, user_id) VALUES (?,?)";
            jdbcTemplate.update(sql,lessonId,userId);
        }
    }

    @Override
    public boolean checkLessonCompletion(int lessonId, int userId) {
        String sql = "SELECT count(*) FROM lesson_users WHERE lesson_id = ? AND user_id = ?";
        boolean exists = false;
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class, lessonId, userId);

        if (count > 0) {
            exists = true;
        }
        return exists;
    }

    @Override
    public double checkCourseCompletion(int courseId, int userId) {
        String sql = "SELECT progress FROM users_course WHERE course_id = ? AND user_id = ?;";

        Double results = jdbcTemplate.queryForObject(sql, Double.class, courseId, userId);

        System.out.println(results);

        return results;

    }


    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }
}
